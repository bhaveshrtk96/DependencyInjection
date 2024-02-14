package com.example.difinalroomretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.difinalroomretrofit.UserViewModel.UserViewModel
import com.example.difinalroomretrofit.interactors.UserInteractor
import com.example.difinalroomretrofit.localdatasource.UserLocalDataSource
import com.example.difinalroomretrofit.manualDI.FlowAppContainer
import com.example.difinalroomretrofit.remotedatasource.RemoteDataSource
import com.example.difinalroomretrofit.repository.UserRepository
import com.example.difinalroomretrofit.roomDataBase.SampleDataBase
import com.example.difinalroomretrofit.roomDataBase.entity.RoomUserEntity
import com.example.difinalroomretrofit.usecase.*

class MainActivity : AppCompatActivity() {

    private val TAG_DI = "DEPENDENCY INJECTION"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * This is the code you will need to write everywhere you are using viewmodel
         * if you are not using DI
         */

        val dao = SampleDataBase.getDataBaseInstance(this)?.getRoomUserDao()
        val localDataSource = dao?.let { UserLocalDataSource(it) }
        val remoteDataSource = RemoteDataSource()
        val userRepository = localDataSource?.let { UserRepository(it, remoteDataSource) } ?: return
        val userInteractor = UserInteractor(
            GetAllUserUseCaseLocal(userRepository),
            GetUserUseCase(userRepository),
            InsertUserUseCaseLocal(userRepository),
            sendUserUseCase(userRepository),
            UpdateUserUseCaseLocal(userRepository)
        )
        val userViewModelWithoutDI = UserViewModel(userInteractor)

        /**
         * This Code is required for Manual Dependency Injection
         * Create AppContainer which will have all above boilerplate code
         * and will also need application class which will have app container instance
         * which we can access any where inside application since it is in application class
         */

        //in below case u will observe address printed is different it means both
        //view model are of different instances
        val appContainer = (application as MyApplication).appContainer
        val userViewModelWithDIWithoutFactory = appContainer.userInteractor?.let { UserViewModel(it) }
        Log.i(TAG_DI, "userViewModel = $userViewModelWithDIWithoutFactory")

        val userViewModelWithDIWithoutFactory1 = appContainer.userInteractor?.let { UserViewModel(it) }
        Log.i(TAG_DI, "userViewModel1 = $userViewModelWithDIWithoutFactory1")

        /**
         * You can also delegate creation of viewmodel to appcontainer
         * for that you will need view model factory.
         * And we willa also use ViewModelProvider for creation of view model.
         * Use of ViewModelProvider is necessary if you want to share view model across
         * fragment.
         */

        appContainer.flowAppContainer = appContainer.userInteractor?.let { FlowAppContainer(it) }
        //in below case view model instances is same
        val userViewModelWithFactory = ViewModelProvider(this,appContainer.flowAppContainer?.userViewModelFactory!!).get(UserViewModel::class.java)
        Log.i(TAG_DI, "userViewModel = $userViewModelWithFactory")

        val userViewModelWithFactory1 = ViewModelProvider(this,appContainer.flowAppContainer?.userViewModelFactory!!).get(UserViewModel::class.java)
        Log.i(TAG_DI, "userViewModel1 = $userViewModelWithFactory1")

        userViewModelWithFactory.insertUser(RoomUserEntity(userName = "Bhavesh"))
        userViewModelWithFactory.sendUser()
        userViewModelWithFactory.getUser()

        //from here we will start with Dagger
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
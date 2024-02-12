package com.example.difinalroomretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.difinalroomretrofit.UserViewModel.UserViewModel
import com.example.difinalroomretrofit.interactors.UserInteractor
import com.example.difinalroomretrofit.localdatasource.UserLocalDataSource
import com.example.difinalroomretrofit.remotedatasource.RemoteDataSource
import com.example.difinalroomretrofit.repository.UserRepository
import com.example.difinalroomretrofit.roomDataBase.SampleDataBase
import com.example.difinalroomretrofit.roomDataBase.entity.RoomUserEntity
import com.example.difinalroomretrofit.usecase.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * This is the code you will need to write everywhere you are using viewmodel
         * if you are not using DI
         */

/*        val dao = SampleDataBase.getDataBaseInstance(this)?.getRoomUserDao()
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
        val userViewModel = UserViewModel(userInteractor)*/

        /**
         * This Code is required for Manual Dependecy Injection
         * Create AppContainer which will have all above boilerplate code
         * and will also need application class which will have appcontainer instance
         * which we can access any where inside application since it is in application class
         */
        val appContainer = (application as MyApplication).appContainer
/*        val userViewModel = appContainer.userInteractor?.let { UserViewModel(it) }
        Log.i("Bhavesh", "userViewModel = $userViewModel")

        val userViewModel1 = appContainer.userInteractor?.let { UserViewModel(it) }
        Log.i("Bhavesh", "userViewModel1 = $userViewModel1")*/

        /**
         * You can also delegate creation of viewmodel to appcontainer
         * for that you will need view model factory
         */

        val userViewModel = ViewModelProvider(this,appContainer.userViewModelFactory!!).get(UserViewModel::class.java)
        Log.i("Bhavesh", "userViewModel = $userViewModel")

        val userViewModel1 = ViewModelProvider(this,appContainer.userViewModelFactory!!).get(UserViewModel::class.java)
        Log.i("Bhavesh", "userViewModel1 = $userViewModel1")

        userViewModel?.insertUser(RoomUserEntity(userName = "Bhavesh"))
        userViewModel?.sendUser()
        userViewModel?.getUser()
    }
}
package com.example.difinalroomretrofit.manualDI

import android.content.Context
import com.example.difinalroomretrofit.interactors.UserInteractor
import com.example.difinalroomretrofit.localdatasource.UserLocalDataSource
import com.example.difinalroomretrofit.remotedatasource.RemoteDataSource
import com.example.difinalroomretrofit.repository.UserRepository
import com.example.difinalroomretrofit.roomDataBase.SampleDataBase
import com.example.difinalroomretrofit.usecase.*

class AppContainer(context: Context) {
    private val dao = SampleDataBase.getDataBaseInstance(context)?.getRoomUserDao()
    private val localDataSource = dao?.let { UserLocalDataSource(it) }
    private val remoteDataSource = RemoteDataSource()
    private val userRepository = localDataSource?.let { UserRepository(it, remoteDataSource) }
    val userInteractor = userRepository?.let { GetAllUserUseCaseLocal(it) }?.let {
        UserInteractor(
            it,
            GetUserUseCase(userRepository),
            InsertUserUseCaseLocal(userRepository),
            sendUserUseCase(userRepository),
            UpdateUserUseCaseLocal(userRepository)
        )
    }
    //This is moved to flow container
   /* val userViewModelFactory = userInteractor?.let { UserViewModelFactory(it) }*/
    var flowAppContainer : FlowAppContainer? = null
}
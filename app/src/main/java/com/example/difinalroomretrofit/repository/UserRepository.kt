package com.example.difinalroomretrofit.repository

import com.example.difinalroomretrofit.localdatasource.IUserLocalDataSource
import com.example.difinalroomretrofit.remotedatasource.IRemoteDataSource
import com.example.difinalroomretrofit.roomDataBase.entity.RoomUserEntity

class UserRepository(
    val localDataSource: IUserLocalDataSource,
    val remoteDataSource: IRemoteDataSource
) {
    suspend fun insertUser(userEntity: RoomUserEntity) {
        localDataSource.insertUser(userEntity)
    }

    suspend fun updateUser(userEntity: RoomUserEntity) {
        localDataSource.updateUser(userEntity)
    }

    suspend fun getAllUser(): MutableList<RoomUserEntity> {
        return localDataSource.getAllUser()
    }

    fun getUser() {
        remoteDataSource.getUser()
    }

    fun sendUser() {
        remoteDataSource.sendUser()
    }

}
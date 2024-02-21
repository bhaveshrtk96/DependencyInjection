package com.example.difinalroomretrofit.localdatasource

import com.example.difinalroomretrofit.roomDataBase.dao.UserDao
import com.example.difinalroomretrofit.roomDataBase.entity.RoomUserEntity
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(val dao: UserDao): IUserLocalDataSource {
    override suspend fun insertUser(userEntity: RoomUserEntity) {
        dao.insertUser(userEntity)
    }

    override suspend fun updateUser(userEntity: RoomUserEntity) {
        dao.updateUser(userEntity)
    }

    override suspend fun getAllUser(): MutableList<RoomUserEntity> {
       return dao.getAllUser()
    }
}
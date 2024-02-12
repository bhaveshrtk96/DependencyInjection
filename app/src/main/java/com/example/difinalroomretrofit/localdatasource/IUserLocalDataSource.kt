package com.example.difinalroomretrofit.localdatasource

import com.example.difinalroomretrofit.roomDataBase.entity.RoomUserEntity

interface IUserLocalDataSource {
    suspend fun insertUser(userEntity: RoomUserEntity)
    suspend fun updateUser(userEntity: RoomUserEntity)
    suspend fun getAllUser(): MutableList<RoomUserEntity>
}
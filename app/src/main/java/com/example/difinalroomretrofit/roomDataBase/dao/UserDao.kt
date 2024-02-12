package com.example.difinalroomretrofit.roomDataBase.dao

import androidx.room.*
import com.example.difinalroomretrofit.roomDataBase.entity.RoomUserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: RoomUserEntity)

    @Update
    suspend fun updateUser(userEntity: RoomUserEntity)

    @Query("SELECT * FROM UserDataBase")
    suspend fun getAllUser(): MutableList<RoomUserEntity>
}
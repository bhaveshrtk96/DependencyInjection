package com.example.difinalroomretrofit.roomDataBase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "UserDataBase")
data class RoomUserEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    var createdDate: Date = Date(),
    var userName: String = ""
)
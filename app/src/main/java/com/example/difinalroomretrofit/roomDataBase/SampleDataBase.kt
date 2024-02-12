package com.example.difinalroomretrofit.roomDataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.difinalroomretrofit.roomDataBase.dao.UserDao
import com.example.difinalroomretrofit.roomDataBase.entity.RoomUserEntity
import com.example.difinalroomretrofit.roomDataBase.typeconvertors.TypeConvertor

@Database(entities = [RoomUserEntity::class], version = 1, exportSchema = true)
@TypeConverters(TypeConvertor::class)
abstract class SampleDataBase : RoomDatabase() {
    abstract fun getRoomUserDao(): UserDao

    companion object {
        var instance: SampleDataBase? = null

        @Synchronized
        fun getDataBaseInstance(context: Context): SampleDataBase? {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context, SampleDataBase::class.java, "RoomDataBase").build()
            }
            return instance
        }
    }
}
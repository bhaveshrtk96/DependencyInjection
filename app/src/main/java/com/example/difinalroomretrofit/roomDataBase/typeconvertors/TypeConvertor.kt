package com.example.difinalroomretrofit.roomDataBase.typeconvertors

import androidx.room.TypeConverter
import java.util.*

class TypeConvertor {

    @TypeConverter
    fun toLong(date : Date): Long{
        return date.time
    }

    @TypeConverter
    fun toDate(time: Long) : Date{
        return toDate(time)
    }
}
package com.example.difinalroomretrofit.daggerdi

import android.content.Context
import com.example.difinalroomretrofit.MainActivity
import com.example.difinalroomretrofit.network.FakeApiQueries
import com.example.difinalroomretrofit.roomDataBase.dao.UserDao
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitRoomModule::class])
interface DiComponentAppLevel {
    //fun getUserViewModel(): UserViewModel

    //fun inject(mainActivity: MainActivity)

    fun providesUserDao() : UserDao
    fun providesFakeApiQueries(): FakeApiQueries

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance @Named("int1") int1: Int,
            @BindsInstance @Named("int2") int2: Int
        ): DiComponentAppLevel
        //if you are binding more than one instance of same data type than you
        //have to use @named annotation
    }


}
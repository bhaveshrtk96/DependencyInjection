package com.example.difinalroomretrofit.daggerdi

import android.content.Context
import com.example.difinalroomretrofit.UserViewModel.UserViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataSourceModule::class, RetrofitRoomModule::class])
interface DiComponent {
    fun getUserViewModel(): UserViewModel

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context):DiComponent
    }

}
package com.example.difinalroomretrofit.daggerdi

import com.example.difinalroomretrofit.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [DataSourceModule::class])
interface DIDaggerActivityLevel {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        //fun create(appLevel: DiComponentAppLevel): DIDaggerActivityLevel
        fun create(@BindsInstance int3 : Int) : DIDaggerActivityLevel
    }
}
package com.example.difinalroomretrofit.daggerdi

import com.example.difinalroomretrofit.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [DiComponentAppLevel::class], modules = [DataSourceModule::class])
interface DIDaggerActivityLevel {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(appLevel: DiComponentAppLevel): DIDaggerActivityLevel
    }
}
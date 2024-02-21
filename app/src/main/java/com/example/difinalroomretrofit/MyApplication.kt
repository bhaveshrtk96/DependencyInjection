package com.example.difinalroomretrofit

import android.app.Application
import com.example.difinalroomretrofit.daggerdi.DaggerDiComponent
import com.example.difinalroomretrofit.daggerdi.DiComponent
import com.example.difinalroomretrofit.manualDI.AppContainer

class MyApplication : Application() {
    lateinit var appContainer: AppContainer
    lateinit var daggerDiComponent: DiComponent
    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(applicationContext)
        daggerDiComponent = DaggerDiComponent.factory().create(this)
    }
}
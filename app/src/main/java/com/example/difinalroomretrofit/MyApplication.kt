package com.example.difinalroomretrofit

import android.app.Application
import com.example.difinalroomretrofit.daggerdi.DaggerDiComponentAppLevel
import com.example.difinalroomretrofit.daggerdi.DiComponentAppLevel
import com.example.difinalroomretrofit.manualDI.AppContainer

class MyApplication : Application() {
    lateinit var appContainer: AppContainer
    lateinit var daggerDiComponentAppLevel: DiComponentAppLevel
    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(applicationContext)
        //daggerDiComponentAppLevel = DaggerDiComponentAppLevel.factory().create(this,5,10)
        daggerDiComponentAppLevel =
            DaggerDiComponentAppLevel
                .builder()
                .bindsContext(this)
                .bindsInt1(50)
                .bindsInt2(10)
                .build()
    }
}
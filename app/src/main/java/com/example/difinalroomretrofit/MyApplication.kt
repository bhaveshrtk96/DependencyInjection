package com.example.difinalroomretrofit

import android.app.Application
import com.example.difinalroomretrofit.manualDI.AppContainer

class MyApplication : Application() {
    lateinit var appContainer : AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(applicationContext)
    }
}
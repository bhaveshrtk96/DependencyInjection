package com.example.difinalroomretrofit.remotedatasource

import android.util.Log

class RemoteDataSource: IRemoteDataSource {
    override fun getUser() {
        Log.i("RemoteDataSource","getUser")
    }

    override fun sendUser() {
        Log.i("RemoteDataSource","sendUser")
    }
}
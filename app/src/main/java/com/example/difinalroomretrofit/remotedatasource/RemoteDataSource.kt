package com.example.difinalroomretrofit.remotedatasource

import android.util.Log
import com.example.fakeapiretrofit.network.FakeApiQueries

class RemoteDataSource(val fakeApiQueries: FakeApiQueries): IRemoteDataSource {
    override fun getUser() {
        Log.i("RemoteDataSource","getUser")
    }

    override fun sendUser() {
        Log.i("RemoteDataSource","sendUser")
    }
}
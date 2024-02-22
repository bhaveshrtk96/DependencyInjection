package com.example.difinalroomretrofit.daggerdi

import com.example.difinalroomretrofit.localdatasource.IUserLocalDataSource
import com.example.difinalroomretrofit.localdatasource.UserLocalDataSource
import com.example.difinalroomretrofit.remotedatasource.IRemoteDataSource
import com.example.difinalroomretrofit.remotedatasource.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
/*
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsRemoteDataSource(remoteDataSource: RemoteDataSource): IRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsLocalDataSource(localDataSource: UserLocalDataSource): IUserLocalDataSource
}*/
class DataSourceModule {
    @Provides
    @ActivityScope
    fun bindsRemoteDataSource(remoteDataSource: RemoteDataSource): IRemoteDataSource{
        return remoteDataSource
    }

    @Provides
    @ActivityScope
    fun bindsLocalDataSource(localDataSource: UserLocalDataSource): IUserLocalDataSource{
        return localDataSource
    }
}
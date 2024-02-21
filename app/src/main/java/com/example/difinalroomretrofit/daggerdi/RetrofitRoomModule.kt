package com.example.difinalroomretrofit.daggerdi

import android.content.Context
import androidx.room.Room
import com.example.difinalroomretrofit.network.FakeApiQueries
import com.example.difinalroomretrofit.roomDataBase.SampleDataBase
import com.example.difinalroomretrofit.roomDataBase.dao.UserDao
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetrofitRoomModule {

    @Provides
    @Singleton
    fun providesUserRoom(context: Context): SampleDataBase {
        return Room.databaseBuilder(context, SampleDataBase::class.java, "RoomDataBase").build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient =
            OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build()
        return okHttpClient
    }

    @Provides
    fun providesFakeApiQuery(okHttpClient: OkHttpClient): FakeApiQueries {
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build().create(FakeApiQueries::class.java)
    }

    @Provides
    fun providesUserDao(sampleDataBase: SampleDataBase):UserDao{
        return sampleDataBase.getRoomUserDao()
    }
}
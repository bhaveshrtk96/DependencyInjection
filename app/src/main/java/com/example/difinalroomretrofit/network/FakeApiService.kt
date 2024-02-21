package com.example.difinalroomretrofit.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FakeApiService {
    private val httpLoggingInterceptor = HttpLoggingInterceptor()

    fun getFakeApi(): FakeApiQueries {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        var okHttpClient =
            OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build()
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build().create(FakeApiQueries::class.java)
    }
}
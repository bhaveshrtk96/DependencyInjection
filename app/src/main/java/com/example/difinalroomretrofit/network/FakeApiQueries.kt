package com.example.difinalroomretrofit.network

import com.example.difinalroomretrofit.sharedmodelentities.ProductPojo
import com.example.difinalroomretrofit.sharedmodelentities.ProductPojoItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FakeApiQueries {
    @GET("products")
    suspend fun getAllProducts(): Response<ProductPojo>

    @POST("products")
    suspend fun postProduct(@Body productPojo: ProductPojoItem): Response<ProductPojoItem>
}
package com.example.difinalroomretrofit.remotedatasource

import com.example.difinalroomretrofit.sharedmodelentities.ProductPojo
import com.example.difinalroomretrofit.sharedmodelentities.ProductPojoItem
import retrofit2.Response

interface IRemoteDataSource {
    suspend fun postProduct(productPojo: ProductPojoItem): Response<ProductPojoItem>
    suspend fun getAllProducts(): Response<ProductPojo>
}
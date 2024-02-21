package com.example.difinalroomretrofit.remotedatasource

import android.util.Log
import com.example.difinalroomretrofit.network.FakeApiQueries
import com.example.difinalroomretrofit.sharedmodelentities.ProductPojo
import com.example.difinalroomretrofit.sharedmodelentities.ProductPojoItem
import retrofit2.Response
import retrofit2.http.Body

class RemoteDataSource(val fakeApiQueries: FakeApiQueries): IRemoteDataSource {
    override suspend fun getAllProducts(): Response<ProductPojo> {
        Log.i("RemoteDataSource","getUser")
        return fakeApiQueries.getAllProducts()
    }

    override suspend fun postProduct(productPojo: ProductPojoItem): Response<ProductPojoItem>{
        Log.i("RemoteDataSource","sendUser")
        return fakeApiQueries.postProduct(productPojo)
    }
}
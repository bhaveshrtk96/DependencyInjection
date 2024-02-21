package com.example.difinalroomretrofit.repository

import com.example.difinalroomretrofit.localdatasource.IUserLocalDataSource
import com.example.difinalroomretrofit.remotedatasource.IRemoteDataSource
import com.example.difinalroomretrofit.roomDataBase.entity.RoomUserEntity
import com.example.difinalroomretrofit.sharedmodelentities.ProductPojo
import com.example.difinalroomretrofit.sharedmodelentities.ProductPojoItem
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(
    val localDataSource: IUserLocalDataSource,
    val remoteDataSource: IRemoteDataSource
) {
    suspend fun insertUser(userEntity: RoomUserEntity) {
        localDataSource.insertUser(userEntity)
    }

    suspend fun updateUser(userEntity: RoomUserEntity) {
        localDataSource.updateUser(userEntity)
    }

    suspend fun getAllUser(): MutableList<RoomUserEntity> {
        return localDataSource.getAllUser()
    }

    suspend fun getAllProducts(): Response<ProductPojo> {
        return remoteDataSource.getAllProducts()
    }

    suspend fun postProduct(productPojo: ProductPojoItem): Response<ProductPojoItem> {
        return remoteDataSource.postProduct(productPojo)
    }

}
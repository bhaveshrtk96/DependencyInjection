package com.example.difinalroomretrofit.usecase

import com.example.difinalroomretrofit.repository.UserRepository
import com.example.difinalroomretrofit.sharedmodelentities.ProductPojo
import retrofit2.Response

class GetAllProductsUseCase(val userRepository: UserRepository) {
    operator suspend fun invoke() : Response<ProductPojo> {
        return userRepository.getAllProducts()
    }
}
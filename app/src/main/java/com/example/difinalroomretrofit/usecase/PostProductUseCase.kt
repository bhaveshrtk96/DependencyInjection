package com.example.difinalroomretrofit.usecase

import com.example.difinalroomretrofit.repository.UserRepository
import com.example.difinalroomretrofit.sharedmodelentities.ProductPojoItem
import retrofit2.Response

class PostProductUseCase(val userRepository: UserRepository) {
    operator suspend fun invoke(productPojoItem: ProductPojoItem) : Response<ProductPojoItem> {
        return userRepository.postProduct(productPojoItem)
    }
}
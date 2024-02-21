package com.example.difinalroomretrofit.interactors

import com.example.difinalroomretrofit.usecase.*

data class UserInteractor(
    val getAllUserUseCaseLocal: GetAllUserUseCaseLocal,
    val getAllProductsUseCase: GetAllProductsUseCase,
    val insertUserUseCaseLocal: InsertUserUseCaseLocal,
    val postProductUseCase: PostProductUseCase,
    val updateUserUseCaseLocal: UpdateUserUseCaseLocal
)

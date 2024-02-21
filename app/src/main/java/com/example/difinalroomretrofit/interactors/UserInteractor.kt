package com.example.difinalroomretrofit.interactors

import com.example.difinalroomretrofit.usecase.*
import javax.inject.Inject

data class UserInteractor @Inject constructor(
    val getAllUserUseCaseLocal: GetAllUserUseCaseLocal,
    val getAllProductsUseCase: GetAllProductsUseCase,
    val insertUserUseCaseLocal: InsertUserUseCaseLocal,
    val postProductUseCase: PostProductUseCase,
    val updateUserUseCaseLocal: UpdateUserUseCaseLocal
)

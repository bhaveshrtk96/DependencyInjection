package com.example.difinalroomretrofit.interactors

import com.example.difinalroomretrofit.usecase.*

data class UserInteractor(
    val getAllUserUseCaseLocal: GetAllUserUseCaseLocal,
    val getUserUseCase: GetUserUseCase,
    val insertUserUseCaseLocal: InsertUserUseCaseLocal,
    val sendUserUseCase: sendUserUseCase,
    val updateUserUseCaseLocal: UpdateUserUseCaseLocal
)

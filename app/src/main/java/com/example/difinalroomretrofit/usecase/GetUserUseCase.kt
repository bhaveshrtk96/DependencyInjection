package com.example.difinalroomretrofit.usecase

import com.example.difinalroomretrofit.repository.UserRepository

class GetUserUseCase( val userRepository: UserRepository) {
    operator fun invoke(){
        userRepository.getUser()
    }
}
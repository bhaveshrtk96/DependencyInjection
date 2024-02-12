package com.example.difinalroomretrofit.usecase

import com.example.difinalroomretrofit.repository.UserRepository

class sendUserUseCase( val userRepository: UserRepository) {
    operator fun invoke() {
        userRepository.sendUser()
    }
}
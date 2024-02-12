package com.example.difinalroomretrofit.usecase

import com.example.difinalroomretrofit.repository.UserRepository
import com.example.difinalroomretrofit.roomDataBase.entity.RoomUserEntity

class GetAllUserUseCaseLocal(val userRepository: UserRepository) {
    operator suspend fun invoke(): MutableList<RoomUserEntity>{
        return userRepository.getAllUser()
    }
}
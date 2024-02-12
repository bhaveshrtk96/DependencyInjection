package com.example.difinalroomretrofit.usecase

import com.example.difinalroomretrofit.repository.UserRepository
import com.example.difinalroomretrofit.roomDataBase.entity.RoomUserEntity

class UpdateUserUseCaseLocal(val userRepository: UserRepository) {
    operator suspend fun invoke(userEntity: RoomUserEntity){
        userRepository.updateUser(userEntity)
    }
}
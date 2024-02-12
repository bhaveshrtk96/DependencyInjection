package com.example.difinalroomretrofit.UserViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.difinalroomretrofit.interactors.UserInteractor
import com.example.difinalroomretrofit.roomDataBase.entity.RoomUserEntity
import kotlinx.coroutines.launch

class UserViewModel(val userInteractor: UserInteractor) : ViewModel() {

    private var _userList: MutableLiveData<MutableList<RoomUserEntity>> = MutableLiveData()
    val userList: LiveData<MutableList<RoomUserEntity>> = _userList

    fun insertUser(userEntity: RoomUserEntity) {
        viewModelScope.launch {
            userInteractor.insertUserUseCaseLocal(userEntity)
        }
    }

    fun updateUser(userEntity: RoomUserEntity) {
        viewModelScope.launch {
            userInteractor.updateUserUseCaseLocal(userEntity)
        }
    }

    fun getAllUser() {
        viewModelScope.launch {
            var tempUserList = userInteractor.getAllUserUseCaseLocal()
            _userList.postValue(tempUserList)
        }
    }

    fun getUser() {
        userInteractor.getUserUseCase()
    }

    fun sendUser() {
        userInteractor.sendUserUseCase()
    }
}
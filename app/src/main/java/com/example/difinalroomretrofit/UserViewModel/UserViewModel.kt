package com.example.difinalroomretrofit.UserViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.difinalroomretrofit.interactors.UserInteractor
import com.example.difinalroomretrofit.roomDataBase.entity.RoomUserEntity
import com.example.difinalroomretrofit.sharedmodelentities.ProductPojoItem
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

//@Singleton
class UserViewModel @Inject constructor(val userInteractor: UserInteractor) : ViewModel() {

    private var _userList: MutableLiveData<MutableList<RoomUserEntity>> = MutableLiveData()
    val userList: LiveData<MutableList<RoomUserEntity>> = _userList

    fun insertUserToDB(userEntity: RoomUserEntity) {
        viewModelScope.launch {
            userInteractor.insertUserUseCaseLocal(userEntity)
        }
    }

    fun updateUserToDB(userEntity: RoomUserEntity) {
        viewModelScope.launch {
            userInteractor.updateUserUseCaseLocal(userEntity)
        }
    }

    fun getAllUserFromDb() {
        viewModelScope.launch {
            var tempUserList = userInteractor.getAllUserUseCaseLocal()
            _userList.postValue(tempUserList)
        }
    }

    fun getAllProducts() {
        viewModelScope.launch {
            userInteractor.getAllProductsUseCase().isSuccessful
        }
    }

    fun postProduct() {
        viewModelScope.launch {
            userInteractor.postProductUseCase(ProductPojoItem())
        }
    }
}
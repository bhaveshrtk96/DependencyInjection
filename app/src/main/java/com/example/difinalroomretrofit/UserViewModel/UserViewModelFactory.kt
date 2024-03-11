package com.example.difinalroomretrofit.UserViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.difinalroomretrofit.interactors.UserInteractor
import java.lang.IllegalArgumentException
import javax.inject.Inject

class UserViewModelFactory @Inject constructor(val userInteractor: UserInteractor) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java))
        return UserViewModel(userInteractor) as T

        throw IllegalArgumentException("Unknow class")
    }
}
class UserViewModelFactory1 @Inject constructor(val userViewModel: UserViewModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java))
            return userViewModel as T

        throw IllegalArgumentException("Unknow class")
    }
}
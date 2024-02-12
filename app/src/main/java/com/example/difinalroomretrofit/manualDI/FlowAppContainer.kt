package com.example.difinalroomretrofit.manualDI

import com.example.difinalroomretrofit.UserViewModel.UserViewModelFactory
import com.example.difinalroomretrofit.interactors.UserInteractor

class FlowAppContainer(val userInteractor: UserInteractor) {
    val userViewModelFactory = UserViewModelFactory(userInteractor)
}
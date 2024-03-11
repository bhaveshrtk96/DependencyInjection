package com.example.difinalroomretrofit.UserViewModel

import androidx.lifecycle.ViewModel
import com.example.difinalroomretrofit.interactors.UserInteractor
import javax.inject.Inject

class UserViewModelSample2 @Inject constructor(val userInteractor: UserInteractor): ViewModel() {
}
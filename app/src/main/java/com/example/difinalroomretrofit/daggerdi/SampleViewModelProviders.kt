package com.example.difinalroomretrofit.daggerdi

import androidx.lifecycle.ViewModel
import com.example.difinalroomretrofit.UserViewModel.UserViewModel
import com.example.difinalroomretrofit.UserViewModel.UserViewModelSample2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class SampleViewModelProviders {

    @Binds
    @ClassKey(UserViewModel::class)
    @IntoMap
    abstract fun bindsUserViewModel(userViewModel: UserViewModel) : ViewModel

    @Binds
    @ClassKey(UserViewModelSample2::class)
    @IntoMap
    abstract fun bindsUserViewModelSample2(userViewModel: UserViewModelSample2) : ViewModel

}
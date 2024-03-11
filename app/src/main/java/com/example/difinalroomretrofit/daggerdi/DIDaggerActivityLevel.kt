package com.example.difinalroomretrofit.daggerdi

import androidx.lifecycle.ViewModel
import com.example.difinalroomretrofit.MainActivity
import dagger.Binds
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [DataSourceModule::class, SampleViewModelProviders::class])
interface DIDaggerActivityLevel {
    fun getMap(): Map<Class<*>,ViewModel>
    fun inject(mainActivity: MainActivity)

/*    @Subcomponent.Factory
    interface Factory {
        //fun create(appLevel: DiComponentAppLevel): DIDaggerActivityLevel
        fun create(@BindsInstance int3 : Int) : DIDaggerActivityLevel
    }*/

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun injectInt(int3: Int): Builder
        fun build(): DIDaggerActivityLevel
    }
}
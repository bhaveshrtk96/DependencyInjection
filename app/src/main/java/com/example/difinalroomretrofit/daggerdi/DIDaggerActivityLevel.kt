package com.example.difinalroomretrofit.daggerdi

import com.example.difinalroomretrofit.MainActivity
import dagger.Binds
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [DataSourceModule::class])
interface DIDaggerActivityLevel {
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
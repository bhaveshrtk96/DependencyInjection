package com.example.difinalroomretrofit.daggerdi

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitRoomModule::class])
interface DiComponentAppLevel {
    //fun getUserViewModel(): UserViewModel

    //fun inject(mainActivity: MainActivity)

    /**
     * iF YOU COMMENT BELOW LINES ACTIVTY LEVEL COMPONENT WILL NOT
     * BE ABLE TO ACCESS IT. WE NEED TO EXPOSE IT. ALTERNATIVE IS
     * DEFINING SUBCOMPONENT
     */
/*    fun providesUserDao() : UserDao
    fun providesFakeApiQueries(): FakeApiQueries*/

    //fun getSubComponent(): DIDaggerActivityLevel.Factory
    fun getSubComponent(): DIDaggerActivityLevel.Builder


    /**
     * This by Factory pattern same things we can do through builder patter also
     */
/*    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance @Named("int1") int1: Int,
            @BindsInstance @Named("int2") int2: Int
        ): DiComponentAppLevel
        //if you are binding more than one instance of same data type than you
        //have to use @named annotation
    }*/

    /**
     * This is using builder pattern
     */
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindsContext(context: Context): Builder
        @BindsInstance
        fun bindsInt1(@Named("int1")int1: Int): Builder
        @BindsInstance
        fun bindsInt2(@Named("int2")int2: Int): Builder
        fun build(): DiComponentAppLevel
    }

}
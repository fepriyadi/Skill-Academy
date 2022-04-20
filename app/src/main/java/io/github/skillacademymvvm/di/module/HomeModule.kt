package io.github.skillacademymvvm.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.github.skillacademymvvm.data.HomeDataSource
import io.github.skillacademymvvm.presentation.HomeActivity
import io.github.skillacademymvvm.presentation.HomeViewModel
import io.github.skillacademymvvm.presentation.HomeViewModelCallback
import retrofit2.Retrofit

@Module
abstract class HomeModule {

    @Module
    companion object{

        @JvmStatic
        @Provides
        fun providesHomeDataSource(retrofit: Retrofit) : HomeDataSource = retrofit.create(HomeDataSource::class.java)

        @JvmStatic
        @Provides
        fun providesHomeViewModel(callback: HomeViewModelCallback, dataSource: HomeDataSource): HomeViewModel = HomeViewModel(callback, dataSource)
    }

    @Binds
    abstract fun bindHomeViewModelCallback(activity: HomeActivity): HomeViewModelCallback
}
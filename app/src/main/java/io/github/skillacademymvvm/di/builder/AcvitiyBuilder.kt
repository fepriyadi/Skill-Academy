package io.github.skillacademymvvm.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.skillacademymvvm.di.module.HomeModule
import io.github.skillacademymvvm.di.scope.Presentation
import io.github.skillacademymvvm.presentation.HomeActivity

@Module
abstract class ActivityBuilder {

    @Presentation
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeActivity(): HomeActivity
}
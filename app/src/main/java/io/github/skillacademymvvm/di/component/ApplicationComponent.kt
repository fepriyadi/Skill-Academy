package io.github.skillacademymvvm.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.github.skillacademymvvm.App
import io.github.skillacademymvvm.di.builder.ActivityBuilder
import io.github.skillacademymvvm.di.module.NetWorkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetWorkModule::class, ActivityBuilder::class])
interface ApplicationComponent : AndroidInjector<App>
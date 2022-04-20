package io.github.skillacademymvvm

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.github.skillacademymvvm.di.component.DaggerApplicationComponent

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.create().apply{
            inject(this@App)
        }
    }
}
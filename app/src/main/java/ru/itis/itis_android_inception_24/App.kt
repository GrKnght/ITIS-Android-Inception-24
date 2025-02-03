package ru.itis.itis_android_inception_24

import android.app.Application
import ru.itis.itis_android_inception_24.di.ServiceLocator

class App : Application() {

    private val serviceLocator = ServiceLocator

    override fun onCreate() {
        super.onCreate()
        serviceLocator.initDataLayerDependencies(ctx = this)
    }
}
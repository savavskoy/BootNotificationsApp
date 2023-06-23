package com.example.bootnotificationsapp

import android.app.Application
import com.example.bootnotificationsapp.di.mappersModule
import com.example.bootnotificationsapp.di.repositoryModule
import com.example.bootnotificationsapp.ui.worker.BootEventWorker
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

internal class App : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDi()
        BootEventWorker.scheduleBootEventWork(this)
    }

    private fun configureDi() {
        startKoin {
            module {
                androidContext(this@App)
                androidLogger(level = Level.ERROR)
                modules(provideComponent())
            }
        }
    }

    private fun provideComponent() = listOf(repositoryModule, mappersModule)
}

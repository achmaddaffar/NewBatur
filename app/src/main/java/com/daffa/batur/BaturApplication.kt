package com.daffa.batur

import android.app.Application
import com.daffa.batur.di.modules.appModule
import com.daffa.batur.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class BaturApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BaturApplication)
            androidFileProperties()
            modules(
                appModule,
                viewModelModule
            )
        }
        Timber.plant(Timber.DebugTree())
    }
}
package com.daffa.batur

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaturApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
package com.bobby.cloner

import android.app.Application
import com.bobby.cloner.core.data.remote.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ClonerApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ClonerApplication)
            modules(remoteModule)
        }
    }
}

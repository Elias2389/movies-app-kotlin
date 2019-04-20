package com.arivas.moviesappkotlin.application

import android.app.Application
import com.arivas.moviesappkotlin.di.appModule
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        //Initialize Fresco
        Fresco.initialize(this)

        //Initialize Koin
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}
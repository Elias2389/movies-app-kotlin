package com.arivas.moviesappkotlin.application

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        //Initialize Fresco
        Fresco.initialize(this)
    }
}
package com.arivas.moviesappkotlin.di

import com.arivas.moviesappkotlin.common.network.RetrofitService
import org.koin.dsl.module

val appModule = module {
    single<RetrofitService> { RetrofitService() }
}

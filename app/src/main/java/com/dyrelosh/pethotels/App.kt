package com.dyrelosh.pethotels

import android.app.Application
import com.dyrelosh.pethotels.di.dataDi
import com.dyrelosh.pethotels.di.domainDi
import com.dyrelosh.pethotels.di.presentationDi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(listOf( presentationDi, dataDi, domainDi))
        }
    }
}
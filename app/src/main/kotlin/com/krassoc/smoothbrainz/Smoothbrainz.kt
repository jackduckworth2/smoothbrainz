package com.krassoc.smoothbrainz

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.context.startKoin

import com.krassoc.smoothbrainz.di.appModule

@OptIn(KoinExperimentalAPI::class)
class Smoothbrainz : Application()
{
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Smoothbrainz)
            modules(appModule)
            workManagerFactory()
        }
    }
}

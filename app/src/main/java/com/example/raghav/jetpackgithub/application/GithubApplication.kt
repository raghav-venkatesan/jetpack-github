package com.example.raghav.jetpackgithub.application

import android.app.Application
import com.example.raghav.jetpackgithub.di.AppComponent
import com.example.raghav.jetpackgithub.di.AppModule
import com.example.raghav.jetpackgithub.di.DaggerAppComponent

class GithubApplication : Application() {

    companion object {
        lateinit var instance: GithubApplication

        val component: AppComponent by lazy {
            DaggerAppComponent.builder()
                    .appModule(AppModule(instance))
                    .build()
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}

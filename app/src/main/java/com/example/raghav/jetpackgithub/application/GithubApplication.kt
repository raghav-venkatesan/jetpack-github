package com.example.raghav.jetpackgithub.application

import android.app.Application
import com.example.raghav.jetpackgithub.di.AppComponent
import com.example.raghav.jetpackgithub.di.DaggerAppComponent

class GithubApplication : Application() {

    companion object {
        val component: AppComponent by lazy {
            DaggerAppComponent.builder().build()
        }
    }

}

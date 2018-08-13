package com.example.raghav.jetpackgithub.application

import android.app.Application
import com.example.raghav.jetpackgithub.di.AppComponent
import com.example.raghav.jetpackgithub.di.DaggerAppComponent
import com.example.raghav.jetpackgithub.di.RetrofitModule

class GithubApplication : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .retrofitModule(RetrofitModule())
                .build()
    }
}

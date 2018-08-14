package com.example.raghav.jetpackgithub.di.Modules

import android.content.Context
import com.example.raghav.jetpackgithub.application.GithubApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(): Context = GithubApplication.instance
}
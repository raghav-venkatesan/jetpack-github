package com.example.raghav.jetpackgithub.di

import com.example.raghav.jetpackgithub.application.GithubApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: GithubApplication) {

    @Provides
    fun githubApplication() = application
}
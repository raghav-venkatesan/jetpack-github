package com.example.raghav.jetpackgithub.di

import com.example.raghav.jetpackgithub.application.GithubApplication
import com.example.raghav.jetpackgithub.room.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun providesUserDao(application: GithubApplication) = AppDatabase.getInstance(application).userDao()

    @Provides
    fun providesRepoDao(application: GithubApplication) = AppDatabase.getInstance(application).repoDao()
}
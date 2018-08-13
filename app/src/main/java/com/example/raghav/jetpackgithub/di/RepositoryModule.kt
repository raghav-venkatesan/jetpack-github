package com.example.raghav.jetpackgithub.di

import com.example.raghav.jetpackgithub.repository.GithubService
import com.example.raghav.jetpackgithub.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(service: GithubService): UserRepository = UserRepository(service)

}
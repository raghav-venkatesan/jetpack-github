package com.example.raghav.jetpackgithub.di.Modules

import com.example.raghav.jetpackgithub.repository.GithubService
import com.example.raghav.jetpackgithub.repository.UserRepository
import com.example.raghav.jetpackgithub.repository.room.UserDao
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(service: GithubService, userDao: UserDao?, executor: Executor): UserRepository
            = UserRepository(service, userDao, executor)

}
package com.example.raghav.jetpackgithub.di

import com.example.raghav.jetpackgithub.ui.UserReposFragment
import com.example.raghav.jetpackgithub.viewmodel.UserReposViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DatabaseModule::class, RetrofitModule::class, RepositoryModule::class])
interface AppComponent {
    fun inject(target: UserReposViewModelFactory)

    fun inject(target: UserReposFragment)
}
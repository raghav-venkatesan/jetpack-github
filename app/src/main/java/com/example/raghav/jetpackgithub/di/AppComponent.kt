package com.example.raghav.jetpackgithub.di

import com.example.raghav.jetpackgithub.viewmodel.UserReposViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, RepositoryModule::class])
interface AppComponent {
    fun injectUserRepo(target: UserReposViewModelFactory)
}
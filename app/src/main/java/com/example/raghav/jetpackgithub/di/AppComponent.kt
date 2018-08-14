package com.example.raghav.jetpackgithub.di

import com.example.raghav.jetpackgithub.viewmodel.UserReposViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, RepositoryModule::class])
interface AppComponent {
    fun injectUserRepo(target: UserReposViewModel)
}
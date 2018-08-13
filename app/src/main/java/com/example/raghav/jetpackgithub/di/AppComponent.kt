package com.example.raghav.jetpackgithub.di

import com.example.raghav.jetpackgithub.ui.UserReposFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface AppComponent {
    fun injectService(target: UserReposFragment)
}
package com.example.raghav.jetpackgithub.di

import com.example.raghav.jetpackgithub.di.Modules.AppModule
import com.example.raghav.jetpackgithub.di.Modules.DatabaseModule
import com.example.raghav.jetpackgithub.di.Modules.RepositoryModule
import com.example.raghav.jetpackgithub.di.Modules.RetrofitModule
import com.example.raghav.jetpackgithub.viewmodel.UserReposViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DatabaseModule::class, RetrofitModule::class, RepositoryModule::class])
interface AppComponent {

    fun injectUserRepo(target: UserReposViewModel)

}
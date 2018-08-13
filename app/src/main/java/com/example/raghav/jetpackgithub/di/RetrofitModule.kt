package com.example.raghav.jetpackgithub.di

import com.example.raghav.jetpackgithub.repository.GithubService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }

}
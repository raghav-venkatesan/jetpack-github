package com.example.raghav.jetpackgithub.di.Modules

import android.content.Context
import com.example.raghav.jetpackgithub.repository.room.UserDao
import com.example.raghav.jetpackgithub.repository.room.UserDatabase
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors

@Module
class DatabaseModule {

    @Provides
    fun provideDatabase(context: Context): UserDatabase? = UserDatabase.getInstance(context)

    @Provides
    fun provideDao(db: UserDatabase?): UserDao? = db?.userDao()

    @Provides
    fun provideExecutor(): Executor = Executors.newFixedThreadPool(2)
}
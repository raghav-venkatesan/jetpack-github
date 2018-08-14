package com.example.raghav.jetpackgithub.repository.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.model.User

@Database(entities = [User::class, Repo::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
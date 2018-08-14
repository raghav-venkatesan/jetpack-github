package com.example.raghav.jetpackgithub.repository.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.model.User
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Query


@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    fun save(user: User)

    @Insert(onConflict = REPLACE)
    fun save(repo: Repo)

    @Query("SELECT * FROM user WHERE userId = :userId")
    fun loadUser(userId: String): LiveData<User>

    @Query("SELECT * FROM repo WHERE userId = :userId")
    fun loadRepos(userId: String): LiveData<List<Repo>>
}
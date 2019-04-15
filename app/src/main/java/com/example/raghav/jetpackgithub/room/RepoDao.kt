package com.example.raghav.jetpackgithub.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.raghav.jetpackgithub.model.Repo

@Dao
interface RepoDao {
    @Query("SELECT * FROM repos")
    fun getRepos(): LiveData<List<Repo>>

    @Query("SELECT * FROM repos WHERE id = :repoId")
    fun getRepo(repoId: Long): LiveData<Repo>

    @Query("SELECT * FROM repos WHERE user_id = :userId")
    fun getRepoForUser(userId: String): LiveData<Repo>

    /**
     * This query will tell Room to query both the [User] and [Repo] tables and handle
     * the object mapping.
     */
    @Transaction
    @Query("SELECT * FROM users")
    fun getUserAndRepos(): LiveData<List<UserAndRepos>>

    @Insert
    fun insertRepo(repo: Repo): Long

    @Delete
    fun deleteRepo(repo: Repo)
}
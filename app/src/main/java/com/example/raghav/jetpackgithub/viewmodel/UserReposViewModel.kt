package com.example.raghav.jetpackgithub.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.model.User
import com.example.raghav.jetpackgithub.repository.UserRepository

class UserReposViewModel : ViewModel() {

    private var user: LiveData<User>? = null
    private var repos: LiveData<List<Repo>>? = null

    fun init(githubUserId: String, userRepo: UserRepository) {
        user = userRepo.getUser(githubUserId)
        repos = userRepo.listRepos(githubUserId)
    }

    fun getUser() = user

    fun getRepos() = repos
}
package com.example.raghav.jetpackgithub.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.raghav.jetpackgithub.application.injectUserRepo
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.model.User
import com.example.raghav.jetpackgithub.repository.UserRepository
import javax.inject.Inject

class UserReposViewModel : ViewModel() {

    private var user: LiveData<User>? = null
    private var repos: LiveData<List<Repo>>? = null
    @Inject
    lateinit var userRepo: UserRepository

    fun init(githubUserId: String) {
        // Inject UserRepository
        injectUserRepo(this)
        user = userRepo.getUser(githubUserId)
        repos = userRepo.listRepos(githubUserId)
    }

    // Only for use by tests
    fun init(githubUserId: String, mockRepo: UserRepository) {
        user = mockRepo.getUser(githubUserId)
        repos = mockRepo.listRepos(githubUserId)
    }

    fun getUser() = user

    fun getRepos() = repos
}
package com.example.raghav.jetpackgithub.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.raghav.jetpackgithub.application.GithubApplication
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.model.User
import com.example.raghav.jetpackgithub.repository.UserRepository
import javax.inject.Inject


class UserReposViewModel : ViewModel() {

    private var user: LiveData<User>? = null
    private var repos: LiveData<List<Repo>>? = null
    @Inject lateinit var userRepo: UserRepository

    fun init(githubUserId: String, application: GithubApplication) {

        application.component.injectUserRepo(this)

        user = userRepo.getUser(githubUserId)
        repos = userRepo.listRepos(githubUserId)
    }

    fun getUser() = user

    fun getRepos() = repos
}
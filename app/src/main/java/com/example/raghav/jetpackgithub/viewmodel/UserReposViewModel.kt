package com.example.raghav.jetpackgithub.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.model.User

class UserReposViewModel : ViewModel() {
    var userId: String? = null
    private var user: LiveData<User>? = null
    private var repos: LiveData<List<Repo>>? = null

    fun init(githubUserId: String) {
        userId = githubUserId
        val data = MutableLiveData<User>()
        data.value = User(userId!!, "com.com")
        user = data
    }

    fun getUser() = user

    fun getRepos() = repos
}
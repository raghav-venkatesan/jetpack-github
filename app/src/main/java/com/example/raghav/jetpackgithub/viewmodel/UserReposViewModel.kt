package com.example.raghav.jetpackgithub.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.raghav.jetpackgithub.application.injectUserRepo
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.repository.UserRepository
import javax.inject.Inject

class UserReposViewModel(private val userRepo: UserRepository) : ViewModel() {

    val userName = MutableLiveData<String>()
    val avatarUrl = MutableLiveData<String>()
    val reposList = MutableLiveData<List<Repo>>()

    fun init(githubUserId: String) {
        userRepo.getUser(githubUserId) {
            userName.postValue(it.name)
            avatarUrl.postValue(it.avatar_url)
        }

        userRepo.listRepos(githubUserId) {
            reposList.postValue(it)
        }
    }
}
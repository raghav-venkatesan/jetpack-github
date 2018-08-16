package com.example.raghav.jetpackgithub.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.model.User
import com.example.raghav.jetpackgithub.repository.UserRepository
import com.example.raghav.jetpackgithub.viewmodel2.KittyRepository

class UserReposViewModel : ViewModel() {

    private var user: LiveData<User>? = null
    private var repos: LiveData<List<Repo>>? = null
    private val kittyRepository = KittyRepository()

    val kittyName = MutableLiveData<String>()
    val kittyAge = MutableLiveData<Int>()

    fun init(githubUserId: String, userRepo: UserRepository) {
        user = userRepo.getUser(githubUserId)
        repos = userRepo.listRepos(githubUserId)

        kittyRepository.receiveNewKitties {
            kittyName.postValue(it.name)
            kittyAge.postValue(it.age)
        }
    }

    fun getUser() = user

    fun getRepos() = repos
}
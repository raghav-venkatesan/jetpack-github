package com.example.raghav.jetpackgithub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.raghav.jetpackgithub.application.injectUserRepo
import com.example.raghav.jetpackgithub.repository.UserRepository
import javax.inject.Inject


class UserReposViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    @Inject
    lateinit var userRepo: UserRepository

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        injectUserRepo(this)

        return UserReposViewModel(userRepo) as T
    }
}
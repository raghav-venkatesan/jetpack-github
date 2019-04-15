package com.example.raghav.jetpackgithub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.raghav.jetpackgithub.application.inject
import com.example.raghav.jetpackgithub.repository.UserRepository
import javax.inject.Inject


class UserReposViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    @Inject
    lateinit var userRepo: UserRepository

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        inject(this)

        return UserReposViewModel(userRepo) as T
    }
}
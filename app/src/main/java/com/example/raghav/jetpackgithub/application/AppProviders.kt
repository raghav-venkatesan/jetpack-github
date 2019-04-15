package com.example.raghav.jetpackgithub.application

import com.example.raghav.jetpackgithub.viewmodel.UserReposViewModelFactory

fun component() = GithubApplication.component

fun injectUserRepo(target: UserReposViewModelFactory) = component().injectUserRepo(target)
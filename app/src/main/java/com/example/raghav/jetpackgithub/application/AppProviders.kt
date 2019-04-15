package com.example.raghav.jetpackgithub.application

import com.example.raghav.jetpackgithub.ui.UserReposFragment
import com.example.raghav.jetpackgithub.viewmodel.UserReposViewModelFactory

fun component() = GithubApplication.component

fun inject(target: UserReposViewModelFactory) = component().inject(target)

fun inject(target: UserReposFragment) = component().inject(target)
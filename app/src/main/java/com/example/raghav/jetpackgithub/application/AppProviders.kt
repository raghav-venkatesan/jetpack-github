package com.example.raghav.jetpackgithub.application

import com.example.raghav.jetpackgithub.viewmodel.UserReposViewModel

fun component() = GithubApplication.component

fun injectUserRepo(target: UserReposViewModel) = component().injectUserRepo(target)
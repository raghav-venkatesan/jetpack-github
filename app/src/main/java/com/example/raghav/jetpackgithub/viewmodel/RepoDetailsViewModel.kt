package com.example.raghav.jetpackgithub.viewmodel

import android.arch.lifecycle.ViewModel
import com.example.raghav.jetpackgithub.model.Repo

data class RepoDetailsViewModel(val repo: Repo) : ViewModel()
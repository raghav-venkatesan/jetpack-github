package com.example.raghav.jetpackgithub.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity data class Repo(@PrimaryKey val userId: String, val name: String, val description: String, val updated_at: String, val stargazers_count: Int, val forks: Int)
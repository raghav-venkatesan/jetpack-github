package com.example.raghav.jetpackgithub.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity data class User(@PrimaryKey val login: String, val name: String, val avatar_url: String)
package com.example.raghav.jetpackgithub.room

import androidx.room.Embedded
import androidx.room.Relation
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.model.User


class UserAndRepos {

    @Embedded
    lateinit var user: User

    @Relation(parentColumn = "id", entityColumn = "user_id")
    var repos: List<Repo> = arrayListOf()
}
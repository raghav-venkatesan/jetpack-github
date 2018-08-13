package com.example.raghav.jetpackgithub.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Singleton

@Singleton
data class UserRepository(val service: GithubService) {

    fun getUser(userId: String): LiveData<User>? {
        val data = MutableLiveData<User>()

        service.getUser(userId).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>?, t: Throwable?) {
                println("retrofit user failure " + t.toString())
            }

            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                val user = response?.body()
                data.value = user
                println("retrofit user success " + user.toString())
            }
        })

        return data
    }

    fun listRepos(userId: String): LiveData<List<Repo>>? {
        val data = MutableLiveData<List<Repo>>()

        service.listRepos(userId).enqueue(object : Callback<List<Repo>> {
            override fun onFailure(call: Call<List<Repo>>?, t: Throwable?) {
                println("retrofit reposList failure " + t.toString())
            }

            override fun onResponse(call: Call<List<Repo>>?, response: Response<List<Repo>>?) {
                val reposList = response?.body()
                data.value = reposList
                println("retrofit reposList success")
                reposList?.forEach { println(it.toString()) }
            }
        })

        return data
    }
}
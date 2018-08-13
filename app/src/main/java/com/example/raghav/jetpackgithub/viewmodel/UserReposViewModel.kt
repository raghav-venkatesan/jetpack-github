package com.example.raghav.jetpackgithub.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserReposViewModel : ViewModel() {
    var userId: String? = null
    private var user: LiveData<User>? = null
    private var repos: LiveData<List<Repo>>? = null

    fun init(githubUserId: String, service: GithubService) {

        service.getUser(githubUserId).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>?, t: Throwable?) {
                println("retrofit user failure " + t.toString())
            }

            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                val user = response?.body()
                println("retrofit user success " + user.toString())
            }
        })

        service.listRepos(githubUserId).enqueue(object : Callback<List<Repo>> {
            override fun onFailure(call: Call<List<Repo>>?, t: Throwable?) {
                println("retrofit repos failure " + t.toString())
            }

            override fun onResponse(call: Call<List<Repo>>?, response: Response<List<Repo>>?) {
                val reposList = response?.body()
                println("retrofit repos success ")
                reposList?.forEach { println(it.toString()) }
            }
        })

        userId = githubUserId
        val data = MutableLiveData<User>()
        data.value = User(userId!!, "com.com")
        user = data
    }

    fun getUser() = user

    fun getRepos() = repos
}
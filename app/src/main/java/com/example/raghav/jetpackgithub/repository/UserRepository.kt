package com.example.raghav.jetpackgithub.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.model.User
import com.example.raghav.jetpackgithub.viewmodel2.Kitty
import com.example.raghav.jetpackgithub.viewmodel2.KittyNames
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Singleton

typealias NewKittiesReceived = (Kitty) -> Unit

@Singleton
data class UserRepository(val service: GithubService) {

    val random = Random()

    internal fun receiveNewKitties(newKittiesReceived: NewKittiesReceived) {
//        timer.schedule(object : TimerTask() {
//            override fun run() {
//                val nameRandom = random.nextInt(KittyNames.values().size)
//                val ageRandom = random.nextInt(5)
//
//                newKittiesReceived.invoke(Kitty(KittyNames.values()[nameRandom].name, ageRandom))
//            }
//        }, period, period)

        val nameRandom = random.nextInt(KittyNames.values().size)
        val ageRandom = random.nextInt(5)

        newKittiesReceived.invoke(Kitty(KittyNames.values()[nameRandom].name, ageRandom))
    }

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
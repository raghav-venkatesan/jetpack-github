package com.example.raghav.jetpackgithub.repository

import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.model.User
import com.example.raghav.jetpackgithub.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Singleton

typealias UserReceived = (User) -> Unit
typealias ReposReceived = (List<Repo>) -> Unit

@Singleton
data class UserRepository(val service: GithubService) {

    fun getUser(userId: String, userReceived: UserReceived) {
        service.getUser(userId).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>?, t: Throwable?) {
                println("retrofit user failure " + t.toString())
            }

            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                val user = response?.body()
                user?.let {
                    userReceived.invoke(it)
                }
            }
        })
    }

    fun listRepos(userId: String, reposReceived: ReposReceived) {
        service.listRepos(userId).enqueue(object : Callback<List<Repo>> {
            override fun onFailure(call: Call<List<Repo>>?, t: Throwable?) {
                println("retrofit reposList failure " + t.toString())
            }

            override fun onResponse(call: Call<List<Repo>>?, response: Response<List<Repo>>?) {
                val reposList = response?.body()
                reposList?.let {
                    reposReceived.invoke(it)
                }
            }
        })
    }

//    private fun addUser() {
//        viewModel.viewModelScope.launch {
//            createUser()
//        }
//
//        userDao = AppDatabase.getInstance(context!!).userDao()
//        temp = userDao.getUser("1")
//        temp.observe(viewLifecycleOwner, Observer {
//            println("User Received: ${it.name}")
//        })
//    }
//
//    private suspend fun createUser() {
//        withContext(Dispatchers.IO) {
//            val user = User("1", "kichu", "3")
//            val inserted = userDao.insertUser(user)
//            println("User Inserted $inserted")
//        }
//    }
}
package com.example.raghav.jetpackgithub.viewmodel2

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val kittyRepository = KittyRepository()

    val kittyName = MutableLiveData<String>()
    val kittyAge = MutableLiveData<Int>()

    init {
        kittyRepository.receiveNewKitties {
            kittyName.postValue(it.name)
            kittyAge.postValue(it.age)
        }
    }
}
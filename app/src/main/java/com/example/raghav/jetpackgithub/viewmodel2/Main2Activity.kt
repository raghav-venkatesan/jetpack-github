package com.example.raghav.jetpackgithub.viewmodel2

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.raghav.jetpackgithub.R
import com.example.raghav.jetpackgithub.databinding.ActivityMain2Binding

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMain2Binding? = DataBindingUtil.setContentView(this, R.layout.activity_main2)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding?.let {
            it.viewModel = viewModel
            it.setLifecycleOwner(this)
        }
    }
}

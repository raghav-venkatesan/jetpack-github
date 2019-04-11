package com.example.raghav.jetpackgithub.ui.adapter


import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView

import com.example.raghav.jetpackgithub.R
import com.example.raghav.jetpackgithub.databinding.LayoutRepoDescBinding
import com.example.raghav.jetpackgithub.model.Repo

class ReposAdapter(private val repoList: List<Repo>) : RecyclerView.Adapter<ReposAdapter.MyViewHolder>() {
    private lateinit var layoutInflater: LayoutInflater

    inner class MyViewHolder(val binding: LayoutRepoDescBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<LayoutRepoDescBinding>(layoutInflater, R.layout.layout_repo_desc, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.repo = repoList[position]
    }

    override fun getItemCount(): Int {
        return repoList.size
    }
}
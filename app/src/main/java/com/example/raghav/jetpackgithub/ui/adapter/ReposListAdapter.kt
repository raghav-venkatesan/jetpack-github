package com.example.raghav.jetpackgithub.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.raghav.jetpackgithub.R
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.ui.interfaces.ListItemListener
import kotlinx.android.synthetic.main.layout_repo_desc.view.*

class ReposListAdapter(private val reposList: List<Repo>, private val listItemListener: ListItemListener) : RecyclerView.Adapter<ReposListAdapter.RepoDescHolder>() {

    override fun getItemCount() = reposList.size

    override fun onBindViewHolder(holder: ReposListAdapter.RepoDescHolder, position: Int) {
        val repoItem = reposList[position]
        holder.bindRepo(repoItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposListAdapter.RepoDescHolder {

        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.layout_repo_desc, parent, false)
        return RepoDescHolder(inflatedView, listItemListener)
    }

    class RepoDescHolder(repoView: View, listItemListener: ListItemListener) : RecyclerView.ViewHolder(repoView), View.OnClickListener {
        private var view = repoView
        private var listener = listItemListener
        private var repo: Repo? = null

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            listener.listItemClicked(repo!!)
        }

        fun bindRepo(repo: Repo) {
            this.repo = repo
            view.textViewRepoName.text = repo.name
            view.textViewRepoDesc.text = repo.description
        }
    }
}
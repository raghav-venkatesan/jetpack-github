package com.example.raghav.jetpackgithub.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.raghav.jetpackgithub.R
import com.example.raghav.jetpackgithub.application.GithubApplication
import com.example.raghav.jetpackgithub.databinding.FragmentUserReposBinding
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.ui.adapter.ReposListAdapter
import com.example.raghav.jetpackgithub.ui.customview.CustomBottomSheetDialog
import com.example.raghav.jetpackgithub.ui.interfaces.ListItemListener
import com.example.raghav.jetpackgithub.util.convertTimeFormat
import com.example.raghav.jetpackgithub.viewmodel.UserReposViewModel
import kotlinx.android.synthetic.main.fragment_user_repos.*

/**
 * Fragment to show the list of repositories
 *
 */

class UserReposFragment : Fragment(), ListItemListener {

    private lateinit var viewModel: UserReposViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProviders.of(this@UserReposFragment).get(UserReposViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentUserReposBinding>(
                inflater, R.layout.fragment_user_repos, container, false).apply {
            userReposViewModel = viewModel
            setLifecycleOwner(this@UserReposFragment)
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        repos_list_view.layoutManager = LinearLayoutManager(context)

        searchButton.setOnClickListener {
            viewModel.init(githubUserIdInput.text.toString(), (activity?.application as GithubApplication))

            viewModel.getUser()?.observe(viewLifecycleOwner, Observer { user ->
                githubUserIdTextView.text = user?.name
                Glide.with(activity)
                        .load(user?.avatar_url)
                        .transition(DrawableTransitionOptions.withCrossFade(2000))
                        .into(githubUserImage)

                val slideUpAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_up_profile)
                githubUserIdTextView.startAnimation(slideUpAnimation)
                githubUserImage.startAnimation(slideUpAnimation)
            })

            viewModel.getRepos()?.observe(viewLifecycleOwner, Observer { reposList ->
                reposList?.let {
                    Handler().postDelayed({
                        val reposListAdapter = ReposListAdapter(it, this@UserReposFragment)
                        reposListAdapter.setHasStableIds(true)
                        repos_list_view.adapter = reposListAdapter
                    }, 500)
                }
            })
        }
    }

    override fun listItemClicked(repo: Repo) {
        /*
        Show details of the selected repo using a custom bottom sheet dialog.
        It provides the requisite animations.
         */
        val customBottomSheetDialog
                = CustomBottomSheetDialog(context!!,
                convertTimeFormat(repo.updated_at),
                repo.stargazers_count.toString(),
                repo.forks.toString())
        customBottomSheetDialog.show()
    }
}

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
import com.example.raghav.jetpackgithub.R
import com.example.raghav.jetpackgithub.databinding.FragmentUserReposBinding
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.ui.adapter.ReposAdapter
import com.example.raghav.jetpackgithub.ui.customview.CustomBottomSheetDialog
import com.example.raghav.jetpackgithub.util.convertTimeFormat
import com.example.raghav.jetpackgithub.viewmodel.UserReposViewModel
import kotlinx.android.synthetic.main.fragment_user_repos.*

/**
 * Fragment to show the list of repositories
 *
 */

class UserReposFragment : Fragment() {

    private lateinit var viewModel: UserReposViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProviders.of(this@UserReposFragment).get(UserReposViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentUserReposBinding>(
                inflater, R.layout.fragment_user_repos, container, false).apply {
            userReposViewModel = viewModel
            userReposFragment = this@UserReposFragment
            setLifecycleOwner(this@UserReposFragment)
        }

        viewModel.userName.observe(viewLifecycleOwner, Observer { _ ->
            val slideUpAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_up_profile)
            githubUserIdTextView.startAnimation(slideUpAnimation)
            githubUserImage.startAnimation(slideUpAnimation)
        })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        repos_list_view.layoutManager = LinearLayoutManager(context)
    }

    fun searchButtonClicked() {
        viewModel.init(githubUserIdInput.text.toString())



        viewModel.reposList.observe(viewLifecycleOwner, Observer { reposList ->
            reposList?.let {
                Handler().postDelayed({
                    val reposListAdapter = ReposAdapter(it, this@UserReposFragment)
                    reposListAdapter.setHasStableIds(true)
                    repos_list_view.adapter = reposListAdapter
                }, 500)
            }
        })
    }

    fun listItemClicked(repo: Repo) {
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

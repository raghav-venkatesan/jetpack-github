package com.example.raghav.jetpackgithub.ui

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.raghav.jetpackgithub.R
import com.example.raghav.jetpackgithub.databinding.FragmentUserReposBinding
import com.example.raghav.jetpackgithub.ui.adapter.ReposAdapter
import com.example.raghav.jetpackgithub.viewmodel.UserReposViewModel
import kotlinx.android.synthetic.main.fragment_user_repos.*

/**
 * Fragment to show the list of repositories
 */

class UserReposFragment : Fragment() {

    private lateinit var viewModel: UserReposViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProviders.of(this@UserReposFragment).get(UserReposViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentUserReposBinding>(
                inflater, R.layout.fragment_user_repos, container, false).apply {
            userReposViewModel = viewModel
            lifecycleOwner = this@UserReposFragment
        }

        viewModel.userName.observe(viewLifecycleOwner, Observer {
            val slideUpAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_up_profile)
            github_user_id_text_view.startAnimation(slideUpAnimation)
            github_user_image.startAnimation(slideUpAnimation)
        })

        viewModel.reposList.observe(viewLifecycleOwner, Observer { reposList ->
            reposList?.let {
                Handler().postDelayed({
                    val reposListAdapter = ReposAdapter(it)
                    reposListAdapter.setHasStableIds(true)
                    repos_list_view.adapter = reposListAdapter
                }, 500)
            }
        })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        repos_list_view.layoutManager = LinearLayoutManager(context)
    }

}

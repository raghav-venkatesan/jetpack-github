package com.example.raghav.jetpackgithub.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.raghav.jetpackgithub.R
import com.example.raghav.jetpackgithub.application.GithubApplication
import com.example.raghav.jetpackgithub.databinding.FragmentUserReposBinding
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
            setLifecycleOwner(this@UserReposFragment)
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        searchButton.setOnClickListener {
            viewModel.init(githubUserIdInput.text.toString(), (activity?.application as GithubApplication))

            viewModel.getUser()?.observe(viewLifecycleOwner, Observer { user ->
                githubUserIdTextView.text = user?.name
                Glide.with(activity)
                        .load(user?.avatar_url)
                        .transition(DrawableTransitionOptions.withCrossFade(2000))
                        .into(githubUserImage)

                val slideUpAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_up)
                githubUserIdTextView.startAnimation(slideUpAnimation)
                githubUserImage.startAnimation(slideUpAnimation)
            })
        }

//         Uncomment the code below while setting the click listener for recycler view
//        searchButton.setOnClickListener {
//            /*
//            Show details of the selected repo using a bottom sheet dialog.
//            It provides the requisite animations.
//             */
//            val bottomSheetDialog = BottomSheetDialog(context!!)
//            bottomSheetDialog.setContentView(R.layout.view_repo_detail)
//            // Find the frame layout within the coordinate layout of the bottom sheet dialog to make it transparent
//            bottomSheetDialog.window?.findViewById<FrameLayout>(R.id.design_bottom_sheet)?.setBackgroundResource(android.R.color.transparent);
//            bottomSheetDialog.show()
//        }
    }


}

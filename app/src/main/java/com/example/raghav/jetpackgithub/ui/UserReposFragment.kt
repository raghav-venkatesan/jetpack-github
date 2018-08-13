package com.example.raghav.jetpackgithub.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.raghav.jetpackgithub.R
import com.example.raghav.jetpackgithub.application.GithubApplication
import com.example.raghav.jetpackgithub.databinding.FragmentUserReposBinding
import com.example.raghav.jetpackgithub.viewmodel.GithubService
import com.example.raghav.jetpackgithub.viewmodel.UserReposViewModel
import kotlinx.android.synthetic.main.fragment_user_repos.*
import javax.inject.Inject

/**
 * Fragment to show the list of repositories
 *
 */

class UserReposFragment : Fragment() {

    private lateinit var viewModel: UserReposViewModel
    @Inject lateinit var service: GithubService

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity?.application as GithubApplication).component.injectService(this@UserReposFragment)

        searchButton.setOnClickListener {
            viewModel.init(githubUserIdInput.text.toString(), service)

            viewModel.getUser()?.observe(viewLifecycleOwner, Observer { user ->
                githubUserIdTextView.text = user?.name
            })
        }
    }


}
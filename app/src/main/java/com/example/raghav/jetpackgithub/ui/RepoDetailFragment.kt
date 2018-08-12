package com.example.raghav.jetpackgithub.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.raghav.jetpackgithub.R

/**
 * A simple [Fragment] subclass.
 *
 */
class RepoDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_repo_detail, container, false)

        return view
    }


}

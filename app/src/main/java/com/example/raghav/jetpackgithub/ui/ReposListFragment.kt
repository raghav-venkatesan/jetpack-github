package com.example.raghav.jetpackgithub.ui

import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.raghav.jetpackgithub.R
import kotlinx.android.synthetic.main.fragment_repos_list.*

/**
 * Fragment to show the list of repositories
 *
 */

class ReposListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_repos_list, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchButton.setOnClickListener {
            /*
            Show details of the selected repo using a bottom sheet dialog.
            It provides the requisite animations.
             */
            val bottomSheetDialog = BottomSheetDialog(context!!)
            bottomSheetDialog.setContentView(R.layout.view_repo_detail)
            // Find the frame layout within the coordinate layout of the bottom sheet dialog to make it transparent
            bottomSheetDialog.window?.findViewById<FrameLayout>(R.id.design_bottom_sheet)?.setBackgroundResource(android.R.color.transparent);
            bottomSheetDialog.show()
        }
    }


}

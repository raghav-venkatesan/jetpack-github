package com.example.raghav.jetpackgithub.ui.customview

import android.content.Context
import android.widget.FrameLayout
import android.widget.TextView
import com.example.raghav.jetpackgithub.R
import com.google.android.material.bottomsheet.BottomSheetDialog

class CustomBottomSheetDialog(context: Context, updatedAt: String, stars: String, forks: String): BottomSheetDialog(context) {

    init {
        setContentView(R.layout.view_repo_detail)
        window?.findViewById<FrameLayout>(R.id.design_bottom_sheet)?.setBackgroundResource(android.R.color.transparent)
        window?.findViewById<TextView>(R.id.textViewLastUpdatedValue)?.text = updatedAt
        window?.findViewById<TextView>(R.id.textViewStarsValue)?.text = stars
        window?.findViewById<TextView>(R.id.textViewForksValue)?.text = forks
    }
}
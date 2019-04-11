package com.example.raghav.jetpackgithub.model

import android.view.View
import com.example.raghav.jetpackgithub.ui.customview.CustomBottomSheetDialog
import com.example.raghav.jetpackgithub.util.convertTimeFormat

data class Repo(val name: String, val description: String, val updated_at: String, val stargazers_count: Int, val forks: Int) {
    fun listItemClicked(view: View) {
        /*
        Show details of the selected repo using a custom bottom sheet dialog.
        It provides the requisite animations.
         */
        val customBottomSheetDialog = CustomBottomSheetDialog(view.context,
                convertTimeFormat(updated_at),
                stargazers_count.toString(),
                forks.toString())
        customBottomSheetDialog.show()
    }
}
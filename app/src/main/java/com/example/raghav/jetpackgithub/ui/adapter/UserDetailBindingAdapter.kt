package com.example.raghav.jetpackgithub.ui.adapter

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.raghav.jetpackgithub.model.Repo
import com.example.raghav.jetpackgithub.ui.customview.CustomBottomSheetDialog
import com.example.raghav.jetpackgithub.util.convertTimeFormat

@BindingAdapter("imageFromUrl")
fun imageFromUrl(view: ImageView, imageUrl: String?) {
    imageUrl?.let {
        if (!it.isEmpty()) {
            Glide.with(view.context)
                    .load(it)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(view)
        }
    }
}
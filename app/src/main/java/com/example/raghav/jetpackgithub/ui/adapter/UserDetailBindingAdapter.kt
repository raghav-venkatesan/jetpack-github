package com.example.raghav.jetpackgithub.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

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
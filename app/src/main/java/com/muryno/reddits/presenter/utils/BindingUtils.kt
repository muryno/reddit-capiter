package com.muryno.reddits.presenter.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.Nullable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imagePaths", "pathError", "imageOption")
fun loadImage(imageView: ImageView, @Nullable path:String?, errorDrawable: Drawable, option:String) {
    var myOptions = RequestOptions()
        .placeholder(errorDrawable)
        .error(errorDrawable)


    when(option) {
        "fit" -> myOptions = myOptions.fitCenter()
        "inside" -> myOptions = myOptions.centerInside()
        "crop" -> myOptions = myOptions.centerCrop()
    }

    Glide.with(imageView.context)
        .load(path ?: "")
        .apply(myOptions)
        .into(imageView)
}



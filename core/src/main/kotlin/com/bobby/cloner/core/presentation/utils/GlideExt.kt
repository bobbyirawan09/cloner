package com.bobby.cloner.core.presentation.utils

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget

/**
 * Created by Bobby Irawan on 04/08/21.
 */

fun ImageView.loadUrlWithRoundedCorner(context: Context, url: String) {
    Glide.with(context)
        .asBitmap()
        .load(url)
        .centerCrop()
        .into(object : BitmapImageViewTarget(this) {
            override fun setResource(resource: Bitmap?) {
                val circularBitmapDrawable =
                    RoundedBitmapDrawableFactory.create(context.getResources(), resource)
                circularBitmapDrawable.cornerRadius = 16.0f
                this@loadUrlWithRoundedCorner.setImageDrawable(circularBitmapDrawable)
            }
        })
}

package com.itrocket.hackaton.extension

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.constraintlayout.widget.Group
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import com.bumptech.glide.Glide


/**
 * Created by Dan on 2019-06-06.
 */

var View.visible
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

var View.visibleForHide
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.INVISIBLE
    }

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun Group.addOnClickListener(listener: (view: View) -> Unit) {
    referencedIds.forEach { id ->
        rootView.findViewById<View>(id).setOnClickListener(listener)
    }
}

fun ImageView.setTintColor(@ColorInt colorInt: Int) {
    ImageViewCompat.setImageTintList(this, ColorStateList.valueOf(colorInt))
}

fun ImageView.setTint(@ColorRes colorRes: Int) {
    setTintColor(ContextCompat.getColor(context, colorRes))
}

fun ImageView.loadCircle(
    url: String,
    drawable: Drawable?
) {
    Glide.with(context)
        .load(url)
        .placeholder(drawable)
        .circleCrop()
        .into(this)
}
package com.itrocket.hackaton.extension

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ArrayRes
import androidx.annotation.LayoutRes
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.itrocket.hackaton.R


fun Resources
        .getColorInt(colorId : Int) : Int =  ResourcesCompat.getColor(this, colorId, null)

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun ImageView.loadImage(
    url: String? = null,
    ctx: Context? = null,
    resourceId : Int? = null,
    placeholder : Drawable? = null,
    cornerRadius : Int = 0
) {
    Glide
        .with(ctx ?: context)
        .load(url ?: resourceId)
        .placeholder(placeholder)
        .apply(RequestOptions().apply {
            if (cornerRadius == 0) transform(CenterCrop()) else transform(CenterCrop(), RoundedCorners(cornerRadius))
        })
        .into(this)
}

fun View.visible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}

fun View.changeVisible() {
    this.visibility = if (this.visibility == View.GONE) View.VISIBLE else View.GONE
}



fun BottomNavigationView.removeExtraPadding(){
    val menuView = this.getChildAt(0) as BottomNavigationMenuView

    for (i in 0 until menuView.childCount) {
        val item = menuView.getChildAt(i) as BottomNavigationItemView
        val activeLabel = item.findViewById<View>(R.id.largeLabel)
        if (activeLabel is TextView) {
            activeLabel.setPadding(0, 0, 0, 0)
        }
    }
}

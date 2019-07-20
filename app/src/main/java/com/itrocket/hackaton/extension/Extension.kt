package com.itrocket.hackaton.extension

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
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


fun EditText.onTextChange (callBack : (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher{
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            callBack(s.toString())
        }

    })
}

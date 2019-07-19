package com.itrocket.hackaton.extension

import android.app.Activity
import android.graphics.Rect
import android.util.TypedValue
import java.util.*

/**
 * Created by Dan on 2019-06-07.
 */

private val values = WeakHashMap<String, Int>()

val Activity.statusBarHeight: Int
    get() = values.getOrPut("statusBarHeight") {
        val rectangle = Rect()
        window.decorView.getWindowVisibleDisplayFrame(rectangle)
        if (rectangle.top != 0) {
            rectangle.top
        } else {
            (24 * resources.displayMetrics.density).toInt()
        }
    }

val Activity.actionBarHeight: Int
    get() = values.getOrPut("actionBarHeight") {
        val tv = TypedValue()
        if (theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            TypedValue.complexToDimensionPixelSize(tv.data, resources.displayMetrics)
        } else {
            (56 * resources.displayMetrics.density).toInt()
        }
    }
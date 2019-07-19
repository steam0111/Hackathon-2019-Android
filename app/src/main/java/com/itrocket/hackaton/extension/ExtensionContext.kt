package com.itrocket.hackaton.extension

import android.content.Context
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * Created by Dan on 2019-06-04.
 */

fun Context.toast(text: CharSequence): Toast = Toast.makeText(this, text, Toast.LENGTH_SHORT).apply {
    show()
}

fun Context.toast(@StringRes resId: Int): Toast = Toast.makeText(this, resId, Toast.LENGTH_SHORT).apply { show() }

fun Context.deviceId(): String = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
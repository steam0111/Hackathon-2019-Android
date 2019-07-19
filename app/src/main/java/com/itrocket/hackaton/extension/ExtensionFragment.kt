package com.itrocket.hackaton.extension

import android.graphics.Color
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.itrocket.hackaton.R
import com.readystatesoftware.chuck.internal.ui.MainActivity
import kotlinx.android.synthetic.main.activity_app.*


/**
 * Created by Dan on 2019-06-04.
 */

fun Fragment.toast(text: CharSequence): Toast = activity!!.toast(text)

fun Fragment.toast(@StringRes resId: Int): Toast = activity!!.toast(resId)

//fun Fragment.translucentToolbar(enable: Boolean) {
//    (activity as MainActivity).toolbar.setBackgroundColor(
//        if (enable) Color.TRANSPARENT
//        else getColor(R.color.colorPrimary)
//    )
//}

fun Fragment.visibleToolbar(visible: Boolean) {
    if (visible) {
        (activity as MainActivity).supportActionBar?.show()
    } else {
        (activity as MainActivity).supportActionBar?.hide()
    }
}

fun Fragment.setTitle(title: CharSequence) {
    (activity as MainActivity).supportActionBar?.setTitle(title)
}

fun Fragment.setTitle(@StringRes resId: Int) {
    setTitle(getString(resId))
}

fun Fragment.enableTopPadding() {
    activity?.let { view?.setPadding(0, it.statusBarHeight + it.actionBarHeight, 0, 0) }
}

fun Fragment.enableTopPaddingStatusBar() {
    activity?.let { view?.setPadding(0, it.statusBarHeight, 0, 0) }
}
fun Fragment.getColor(@ColorRes id: Int) = androidx.core.content.ContextCompat.getColor(context!!, id)

fun Fragment.showProgressBar() = (activity as MainActivity).viewProgressBar.show()
fun Fragment.hideProgressBar() = (activity as MainActivity).viewProgressBar.gone()

fun Fragment.findNavController(): NavController =
    Navigation.findNavController(requireActivity(), R.id.fragment_main_nav_host)

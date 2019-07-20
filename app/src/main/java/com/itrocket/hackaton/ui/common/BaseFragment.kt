package com.itrocket.hackaton.ui.common

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.BaseMvpView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.google.android.material.snackbar.Snackbar
import com.itrocket.hackaton.extension.gone
import com.itrocket.hackaton.extension.show
import kotlinx.android.synthetic.main.activity_app.*

abstract class BaseFragment : MvpAppCompatFragment(), BaseMvpView {
    abstract val layoutResId: Int?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutResId?.let { inflater.inflate(it, container, false) }
    }

    fun showMessage(resId: Int) {
        showMessage(getString(resId))
    }

    override fun showMessage(message: String) {
        activity?.let {
            Snackbar.make(it.findViewById(android.R.id.content), message, 2000)
                .setTextColor(Color.WHITE)
                .show()
        }
    }

    override fun showProgress() {
        showProgressBar()
    }

    override fun hideProgress() {
        hideProgressBar()
    }

    private fun Fragment.showProgressBar() = (activity as AppCompatActivity).viewProgressBar.show()
    private fun Fragment.hideProgressBar() = (activity as AppCompatActivity).viewProgressBar.gone()
}
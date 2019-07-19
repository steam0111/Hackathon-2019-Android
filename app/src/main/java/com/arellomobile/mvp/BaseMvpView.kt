package com.arellomobile.mvp

/**
 * Created by Dan on 2019-06-13.
 */
interface BaseMvpView: MvpView {

    fun showMessage(message: String)

    fun showProgress()

    fun hideProgress()
}
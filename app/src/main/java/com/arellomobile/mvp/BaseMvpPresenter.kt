package com.arellomobile.mvp

/**
 * Created by Dan on 2019-06-13.
 */
abstract class BaseMvpPresenter<View : MvpView> : MvpPresenter<View>() {

    override fun onDestroy() {
        super.onDestroy()
    }
}
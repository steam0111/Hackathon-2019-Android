package com.itrocket.hackaton.ui.fragment.home

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.itrocket.hackaton.R
import com.itrocket.hackaton.presentation.presenter.home.MainPresenter
import com.itrocket.hackaton.presentation.view.home.MainView
import com.itrocket.hackaton.ui.common.BaseFragment

class MainFragment : BaseFragment(), MainView {
    companion object {
        const val TAG = "MainFragment"
    }

    override val layoutResId = R.layout.fragment_main

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showMessage("Успешная регистрация")
    }
}
package com.itrocket.hackaton.ui.fragment.test

import android.os.Bundle
import android.view.View
import com.itrocket.hackaton.R
import com.itrocket.hackaton.presentation.view.test.TestView
import com.itrocket.hackaton.presentation.presenter.test.TestPresenter

import com.itrocket.hackaton.ui.common.BaseFragment
import com.arellomobile.mvp.presenter.InjectPresenter

class TestFragment : BaseFragment(), TestView {
    companion object {
        const val TAG = "TestFragment"
    }

    override val layoutResId = R.layout.fragment_test

    @InjectPresenter
    lateinit var testPresenter: TestPresenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
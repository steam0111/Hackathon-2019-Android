package com.itrocket.hackaton.ui.fragment.home

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.arellomobile.mvp.presenter.InjectPresenter
import com.itrocket.hackaton.R
import com.itrocket.hackaton.presentation.presenter.home.MainPresenter
import com.itrocket.hackaton.presentation.view.home.MainView
import com.itrocket.hackaton.ui.common.BaseFragment
import com.itrocket.hackaton.ui.common.OnBackPressedListener
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(), MainView, OnBackPressedListener {
    companion object {
        const val TAG = "MainFragment"
    }

    override val layoutResId = R.layout.fragment_main

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    var navController: NavController? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost = childFragmentManager
            .findFragmentById(R.id.home_nav_host_fragment) as NavHostFragment? ?: return

        navController = navHost.navController

        navController?.let {
            setUpBottomNav(it)
        }
    }

    private fun setUpBottomNav(navController: NavController) {
        bottom_nav_view.setupWithNavController(navController)
    }

    override fun onBackPressed(): Boolean {
        return navController?.popBackStack() ?: true
    }
}
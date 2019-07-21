package com.itrocket.hackaton.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.itrocket.hackaton.R
import com.itrocket.hackaton.model.data.storage.Prefs
import com.itrocket.hackaton.ui.common.OnBackPressedListener
import org.koin.android.ext.android.inject
import org.koin.core.KoinComponent

class AppActivity : AppCompatActivity(), KoinComponent {

    var navHost: NavHostFragment? = null
    val prefs: Prefs by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        navHost = supportFragmentManager.findFragmentById(R.id.fragment_main_nav_host) as NavHostFragment?
        val navController = navHost?.navController

        navController?.let {
            val navInflater = navController.navInflater
            val graph = navInflater.inflate(R.navigation.nav_main)

            if (prefs.accessToken.isNullOrEmpty()) {
                graph.startDestination = R.id.loginFragment
            } else {
                graph.startDestination = R.id.mainFragment
            }
            navController.graph = graph
        }
    }

    override fun onBackPressed() {
        val currentFragment = navHost?.childFragmentManager?.fragments?.get(0)
        val controller = Navigation.findNavController(this, R.id.fragment_main_nav_host)

        if (currentFragment is OnBackPressedListener) {
            if (!(currentFragment as OnBackPressedListener).onBackPressed()) {
                super.onBackPressed()
            }
        } else if (!controller.popBackStack()) {
            super.onBackPressed()
        }
    }
}

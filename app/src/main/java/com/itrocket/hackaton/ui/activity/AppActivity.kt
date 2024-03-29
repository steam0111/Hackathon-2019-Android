package com.itrocket.hackaton.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.itrocket.hackaton.R

class AppActivity : AppCompatActivity() {

    var navHost: NavHostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        navHost = supportFragmentManager.findFragmentById(R.id.fragment_main_nav_host) as NavHostFragment?
        val navController = navHost?.navController

        navController?.let {
            val navInflater = navController.navInflater
            val graph = navInflater.inflate(R.navigation.nav_main)

            graph.startDestination = R.id.testFragment
//            if (prefs.isFirstLaunch) {
//                prefs.isFirstLaunch = false
//                graph.startDestination = R.id.onBoardingFragment
//            } else {
//                if (prefs.accessToken.isNullOrEmpty()) {
//                    graph.startDestination = R.id.loginFragment
//                } else {
//                    graph.startDestination = R.id.homeFragment
//                }
//            }
            navController.graph = graph
        }
    }
}

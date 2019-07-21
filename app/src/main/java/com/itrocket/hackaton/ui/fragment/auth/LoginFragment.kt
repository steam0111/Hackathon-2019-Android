package com.itrocket.hackaton.ui.fragment.auth

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.itrocket.hackaton.R
import com.itrocket.hackaton.extension.findNavController
import com.itrocket.hackaton.extension.hideKeyboard
import com.itrocket.hackaton.presentation.presenter.auth.LoginPresenter
import com.itrocket.hackaton.presentation.view.auth.LoginView
import com.itrocket.hackaton.ui.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment(), LoginView {
    companion object {
        const val TAG = "LoginFragment"
    }

    override val layoutResId = R.layout.fragment_login

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAuth.setOnClickListener {
            loginPresenter.btnAuthClick(
                etEmail.text.toString(),
                etPassword.text.toString()
            )

            activity?.hideKeyboard()
        }

        tvReg.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }

    override fun onShowHome() {
        findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
    }
}
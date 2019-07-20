package com.itrocket.hackaton.presentation.presenter.auth

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.itrocket.hackaton.App
import com.itrocket.hackaton.extension.throwableTryToGetErrorMsg
import com.itrocket.hackaton.model.repository.ItRocketRepository
import com.itrocket.hackaton.presentation.view.auth.LoginView
import org.koin.core.KoinComponent
import org.koin.core.inject


@InjectViewState
class LoginPresenter() : MvpPresenter<LoginView>(), KoinComponent {

    private val itRocketRepository : ItRocketRepository by inject()

    fun btnAuthClick(email: String, password: String) {

        if (email.isEmpty()) {
            viewState.showMessage(App.emailNotValidMsg)
            return
        }

        if (password.isEmpty()) {
            viewState.showMessage(App.passwordNotValidMsg)
            return
        }

        itRocketRepository
            .loginStudent(email, password)
            .doOnSubscribe {viewState.showProgress()  }
            .doAfterTerminate { viewState.hideProgress() }
            .subscribe({
                viewState.onShowHome()
            }, {
                it.throwableTryToGetErrorMsg({
                    viewState.showMessage(it)
                }, {
                    viewState.showMessage(App.errorMsg)
                })
            })
    }

}

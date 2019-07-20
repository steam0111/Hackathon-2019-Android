package com.itrocket.hackaton.presentation.presenter.auth

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.itrocket.hackaton.App
import com.itrocket.hackaton.entity.auth.RegRequest
import com.itrocket.hackaton.entity.university.University
import com.itrocket.hackaton.model.repository.ItRocketRepository
import com.itrocket.hackaton.presentation.view.auth.RegistrationView
import org.koin.core.KoinComponent
import org.koin.core.inject

@InjectViewState
class RegistrationPresenter() : MvpPresenter<RegistrationView>(), KoinComponent {

    private val itRocketRepository: ItRocketRepository by inject()

    private var universityId : Int? = null
    private var universities : List<University>? = null

    @SuppressLint("CheckResult")
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        itRocketRepository
            .getUniversity()
            .doOnSubscribe {viewState.showProgress()  }
            .doAfterTerminate { viewState.hideProgress() }
            .subscribe({
                universities = it
                viewState.onShowUniversities(it.map { it.name })
            }, {
                viewState.showMessage(App.errorMsg)
            })
    }


    @SuppressLint("CheckResult")
    fun btnRegClick(
        email: String,
        firstName: String,
        secondName: String,
        lastName: String,
        password: String
    ) {

        if (email.isEmpty()) {
            viewState.showMessage(App.emailNotValidMsg)
            return
        }

        if (firstName.isEmpty()) {
            viewState.showMessage(App.nameNotValidMsg)
            return
        }

        if (secondName.isEmpty()) {
            viewState.showMessage(App.secondNotValidMsg)
            return
        }

        if (lastName.isEmpty()) {
            viewState.showMessage(App.lastNameNotValidMsg)
            return
        }

        if (password.isEmpty()) {
            viewState.showMessage(App.passwordNotValidMsg)
            return
        }

        if (universityId != null) {

            universityId?.let {
                itRocketRepository
                    .regStudent(
                        RegRequest(
                            email,
                            firstName,
                            secondName,
                            lastName,
                            password,
                            it
                        )
                    )
                    .doOnSubscribe { viewState.showProgress()  }
                    .doAfterTerminate { viewState.hideProgress() }
                    .subscribe({
                        viewState.onShowHome()
                    }, {
                        viewState.showMessage(App.errorMsg)
                    })
            }
        } else {
            viewState.showMessage(App.chooseUnivMsg)
        }
    }

    fun onUniversityChange(position: Int) {
        universities?.let {
            universityId = it[position].id
        }

    }
}

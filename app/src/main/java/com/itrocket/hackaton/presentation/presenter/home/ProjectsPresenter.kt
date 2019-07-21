package com.itrocket.hackaton.presentation.presenter.home

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.itrocket.hackaton.App
import com.itrocket.hackaton.model.repository.ItRocketRepository

import com.itrocket.hackaton.presentation.view.home.ProjectsView
import org.koin.core.KoinComponent
import org.koin.core.inject

@InjectViewState
class ProjectsPresenter() : MvpPresenter<ProjectsView>(), KoinComponent {
     private val itRocketRepository : ItRocketRepository by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        itRocketRepository
            .getProject()
            .doOnSubscribe {viewState.showProgress()  }
            .doAfterTerminate { viewState.hideProgress() }
            .subscribe({
                viewState.onShowProject(it)
            }, {
                viewState.showMessage(App.errorMsg)
            })
    }
}

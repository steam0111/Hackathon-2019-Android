package com.itrocket.hackaton.presentation.presenter.home

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.itrocket.hackaton.App
import com.itrocket.hackaton.entity.projects.Project
import com.itrocket.hackaton.extension.throwableTryToGetErrorMsg
import com.itrocket.hackaton.model.repository.ItRocketRepository

import com.itrocket.hackaton.presentation.view.home.ProjectView
import org.koin.core.KoinComponent
import org.koin.core.inject

@InjectViewState
class ProjectPresenter(var project : Project) : MvpPresenter<ProjectView>(), KoinComponent {
      private val itRocketRepository : ItRocketRepository by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        project.isOrdered?.let {
            viewState.onShowStatus(it)
        }

        project.listCompetentions?.let {
            viewState.onShowSkills(it)
        }

    }
     fun onSendBtnClick(id : String) {
         itRocketRepository
             .sendReq(id)
             .doOnSubscribe { viewState.showProgress()  }
             .doAfterTerminate { viewState.hideProgress() }
             .subscribe({
                 viewState.showMessage(it.message)
                 viewState.onShowStatus(0)

             } , {
                 it.throwableTryToGetErrorMsg({
                     viewState.showMessage(it)
                 }, {
                     viewState.showMessage(App.errorMsg)
                 })
             })

     }


}

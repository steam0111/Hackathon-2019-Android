package com.itrocket.hackaton.presentation.presenter.home

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.itrocket.hackaton.App
import com.itrocket.hackaton.model.repository.ItRocketRepository

import com.itrocket.hackaton.presentation.view.home.TrendsView
import org.koin.core.KoinComponent
import org.koin.core.inject

@InjectViewState
class TrendsPresenter() : MvpPresenter<TrendsView>(), KoinComponent {
     private val itRocketRepository : ItRocketRepository by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        itRocketRepository
            .getTrends()
            .doOnSubscribe {viewState.showProgress()  }
            .doAfterTerminate { viewState.hideProgress() }
            .subscribe({
                viewState.onShowTrends(it)
            }, {
                viewState.showMessage(App.errorMsg)
            })
    }
}

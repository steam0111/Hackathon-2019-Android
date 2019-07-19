package com.itrocket.hackaton.presentation.presenter.test

import com.appunite.websocket.rx.RxWebSockets
import com.appunite.websocket.rx.messages.RxEvent
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.itrocket.hackaton.model.repository.ItRocketRepository

import com.itrocket.hackaton.presentation.view.test.TestView
import org.koin.core.KoinComponent
import org.koin.core.inject
import timber.log.Timber
import okhttp3.OkHttpClient
import okhttp3.Request
import org.reactivestreams.Subscription
import rx.functions.Action1


@InjectViewState
class TestPresenter() : MvpPresenter<TestView>(), KoinComponent {
   val itRocketRepository : ItRocketRepository by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        itRocketRepository
            .getTestModel()
            .subscribe({
                Timber.d("")
            }, {
                Timber.d("")
            })

        val request = Request.Builder()
            .get()
            .url("ws://185.246.66.29:8080/api/v1/example_websocket.js")
            .build()
        val subscribe = RxWebSockets(OkHttpClient(), request)
            .webSocketObservable()
            .subscribe { rxEvent ->
                Timber.d(rxEvent.toString())
            }
        Thread.sleep(10000)
        subscribe.unsubscribe()
    }
}

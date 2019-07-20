package com.itrocket.hackaton.presentation.view.auth

import com.arellomobile.mvp.BaseMvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface LoginView : BaseMvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun onShowHome()
}

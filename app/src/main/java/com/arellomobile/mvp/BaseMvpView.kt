package com.arellomobile.mvp

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by Dan on 2019-06-13.
 */


interface BaseMvpView: MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showMessage(message: String)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showProgress()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun hideProgress()
}
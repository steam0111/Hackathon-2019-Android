package com.itrocket.hackaton.presentation.view.auth

import com.arellomobile.mvp.BaseMvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface RegistrationView : BaseMvpView {
   fun onShowUniversities(names : List<String>)

   @StateStrategyType(OneExecutionStateStrategy::class)
   fun onShowHome()
}

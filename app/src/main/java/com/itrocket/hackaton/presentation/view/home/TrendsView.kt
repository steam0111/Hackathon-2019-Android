package com.itrocket.hackaton.presentation.view.home

import com.arellomobile.mvp.BaseMvpView
import com.itrocket.hackaton.entity.Trend

interface TrendsView : BaseMvpView {
    fun onShowTrends(trends : List<Trend>)

}

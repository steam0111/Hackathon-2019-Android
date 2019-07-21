package com.itrocket.hackaton.presentation.view.home

import com.arellomobile.mvp.BaseMvpView

interface ProjectView : BaseMvpView {
    fun onShowStatus(status : Int)
    fun onShowSkills(list : List<String>)
}

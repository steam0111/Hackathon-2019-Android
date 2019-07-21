package com.itrocket.hackaton.presentation.view.home

import com.arellomobile.mvp.BaseMvpView
import com.itrocket.hackaton.entity.projects.Project

interface ProjectsView : BaseMvpView {
   fun onShowProject(projects : List<Project>)
}

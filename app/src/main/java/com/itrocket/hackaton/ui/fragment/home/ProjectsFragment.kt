package com.itrocket.hackaton.ui.fragment.home

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.arellomobile.mvp.presenter.InjectPresenter
import com.itrocket.hackaton.R
import com.itrocket.hackaton.entity.projects.Project
import com.itrocket.hackaton.extension.setLinearLayoutManager
import com.itrocket.hackaton.presentation.presenter.home.ProjectsPresenter
import com.itrocket.hackaton.presentation.view.home.ProjectsView
import com.itrocket.hackaton.ui.common.BaseFragment
import com.itrocket.hackaton.ui.common.BaseRVAdapter
import com.itrocket.hackaton.ui.common.FeedPostDelegateAdapter
import com.itrocket.hackaton.ui.common.MarginItemDecorator
import kotlinx.android.synthetic.main.fragment_projects.*

class ProjectsFragment : BaseFragment(), ProjectsView {
    companion object {
        const val TAG = "ProjectsFragment"
    }

    override val layoutResId = R.layout.fragment_projects

    @InjectPresenter
    lateinit var projectsPresenter: ProjectsPresenter

    private val recyclerVAdapter : BaseRVAdapter by lazy { BaseRVAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerVAdapter.addDelegate(FeedPostDelegateAdapter { project, imageView ->
            findNavController().navigate(R.id.action_projectsFragment_to_projectFragment,
                bundleOf(Pair("project", project)))
        })

        recyclerView.setLinearLayoutManager()
        recyclerView.adapter = recyclerVAdapter
        recyclerView.addItemDecoration(MarginItemDecorator(
            top = resources.getDimension(R.dimen.padding_20).toInt()
        ))
    }

    override fun onShowProject(projects: List<Project>) {
        recyclerVAdapter.setData(projects)
    }
}
package com.itrocket.hackaton.ui.fragment.home

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.itrocket.hackaton.R
import com.itrocket.hackaton.entity.Trend
import com.itrocket.hackaton.extension.setLinearLayoutManager
import com.itrocket.hackaton.presentation.presenter.home.TrendsPresenter
import com.itrocket.hackaton.presentation.view.home.TrendsView
import com.itrocket.hackaton.ui.common.BaseFragment
import com.itrocket.hackaton.ui.common.BaseRVAdapter
import com.itrocket.hackaton.ui.common.TrendsDelegateAdapter
import kotlinx.android.synthetic.main.fragment_projects.recyclerView
import kotlinx.android.synthetic.main.fragment_trends.*

class TrendsFragment : BaseFragment(), TrendsView {
    companion object {
        const val TAG = "TrendsFragment"
    }

    override val layoutResId = R.layout.fragment_trends

    @InjectPresenter
    lateinit var trendsPresenter: TrendsPresenter

    private val recyclerVAdapter : BaseRVAdapter by lazy { BaseRVAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.setLinearLayoutManager()
        recyclerView.adapter = recyclerVAdapter

        recyclerVAdapter.addDelegate(TrendsDelegateAdapter({

        }))

        toolbar.title = "Тренды"
    }

    override fun onShowTrends(trends: List<Trend>) {
        recyclerVAdapter.setData(trends)
    }
}
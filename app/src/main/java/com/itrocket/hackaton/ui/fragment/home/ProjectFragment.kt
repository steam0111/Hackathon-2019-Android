package com.itrocket.hackaton.ui.fragment.home

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.itrocket.hackaton.R
import com.itrocket.hackaton.entity.projects.Project
import com.itrocket.hackaton.extension.loadCircleImage
import com.itrocket.hackaton.extension.loadImage
import com.itrocket.hackaton.extension.setStatus
import com.itrocket.hackaton.extension.visible
import com.itrocket.hackaton.presentation.presenter.home.ProjectPresenter
import com.itrocket.hackaton.presentation.view.home.ProjectView
import com.itrocket.hackaton.ui.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_project.*
import kotlinx.android.synthetic.main.item_project.ivProject

class ProjectFragment : BaseFragment(), ProjectView {
    companion object {
        const val TAG = "ProjectFragment"
    }

    override val layoutResId = R.layout.fragment_project

    @InjectPresenter
    lateinit var projectPresenter: ProjectPresenter

    @ProvidePresenter
    fun getPresenter() = ProjectPresenter(project)

    private val project
        get() = arguments?.getSerializable("project") as Project

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        return inflater.inflate(R.layout.fragment_project, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ivProject.loadImage(url = project.projectFoto)
        tvCompanyName.text = project.company
        ivCompanyPicture.loadCircleImage(url = project.projectFoto)

        tvName.text = "Название проекта : " + project.projectName

        val spannableSubtitlePost = SpannableString("Подано заявок на участие : ")

        spannableSubtitlePost.setSpan(
            StyleSpan(Typeface.NORMAL),
            0,
            spannableSubtitlePost.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        tvCountOrders.append(spannableSubtitlePost)

        val spannableUserName = SpannableString(project.countOrders.toString())

        spannableUserName.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            project.countOrders.toString().length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        tvCountOrders.append(spannableUserName)

        btnRequest.setOnClickListener {
            projectPresenter.onSendBtnClick(project.id)
        }

        textView2.text = if (project.approvedByUniversity.isNotEmpty()) {
            "Проект удтвержден ${project.approvedByUniversity.joinToString(", ")}"
        } else {
            textView2.visibility = View.GONE
            ""
        }

        textView3.text = "Описание проекта : ${project.projectDescription}"

        textView4.visible = project.payment
    }

    override fun onShowStatus(status: Int) {

        btnRequest.visibility = View.INVISIBLE

        setStatus(
            tvStatus,
            ivStatus,
            status)
    }

    override fun onShowSkills(list: List<String>) {
        list.forEach {
            val answerView = layoutInflater.inflate(R.layout.item_skill, null, false)
            answerView.findViewById<TextView>(R.id.tvText).text = it
            llskills.addView(answerView)
        }
    }
}
package com.itrocket.hackaton.ui.common

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.itrocket.hackaton.R
import com.itrocket.hackaton.entity.projects.Project
import com.itrocket.hackaton.extension.inflate
import com.itrocket.hackaton.extension.loadCircleImage
import com.itrocket.hackaton.extension.loadImage
import com.itrocket.hackaton.extension.setStatus
import kotlinx.android.synthetic.main.item_project.view.*

class FeedPostDelegateAdapter(private val clickListener: (Project, ImageView) -> Unit) :
    AdapterDelegate<MutableList<Any>>() {

    override fun isForViewType(items: MutableList<Any>, position: Int) =
        items[position] is Project

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ViewHolder(parent.inflate(R.layout.item_project))

    override fun onBindViewHolder(
        items: MutableList<Any>,
        position: Int,
        viewHolder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) =
        (viewHolder as ViewHolder).bind(items[position] as Project)

    private inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var item: Project

        init {
            view.setOnClickListener {
                clickListener(item, itemView.ivProject)
            }
        }

        fun bind(item: Project) {
            this.item = item


            itemView.ivProject.loadImage(url = item.projectFoto)
            itemView.ivCompanyPicture.loadCircleImage(url = item.companyAvatar)
            itemView.tvCompanyName.text = item.company

            val spannableSubtitlePost = SpannableString("Подано заявок на участие : ")

            spannableSubtitlePost.setSpan(
                StyleSpan(Typeface.NORMAL),
                0,
                spannableSubtitlePost.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            itemView.tvCountOrders.text = ""

            itemView.tvCountOrders.append(spannableSubtitlePost)

            val spannableUserName = SpannableString(item.countOrders.toString())

            spannableUserName.setSpan(
                StyleSpan(Typeface.BOLD),
                0,
                item.countOrders.toString().length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            itemView.tvCountOrders.append(spannableUserName)
            itemView.tvName.text = "Название проекта : " + item.projectName

            item.isOrdered?.let {
                setStatus(
                    itemView.tvStatus,
                    itemView.ivStatus,
                    it)
            }
        }
    }
}
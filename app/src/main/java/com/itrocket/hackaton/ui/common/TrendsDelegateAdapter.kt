package com.itrocket.hackaton.ui.common

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.itrocket.hackaton.R
import com.itrocket.hackaton.entity.Trend
import com.itrocket.hackaton.extension.inflate
import kotlinx.android.synthetic.main.item_popular_skill.view.*

class TrendsDelegateAdapter(private val clickListener: () -> Unit) :
    AdapterDelegate<MutableList<Any>>() {

    override fun isForViewType(items: MutableList<Any>, position: Int) =
        items[position] is Trend

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ViewHolder(parent.inflate(R.layout.item_popular_skill))

    override fun onBindViewHolder(
        items: MutableList<Any>,
        position: Int,
        viewHolder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) =
        (viewHolder as ViewHolder).bind(items[position] as Trend)

    private inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var item: Trend

        init {
            view.setOnClickListener {

            }
        }

        fun bind(item: Trend) {
            this.item = item

            itemView.tvSkillname.text = item.name
            itemView.tvCount.text = item.count.toString()
        }
    }
}
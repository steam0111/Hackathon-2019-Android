package com.itrocket.hackaton.ui.common

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

open class BaseRVAdapter() : ListDelegationAdapter<MutableList<Any>>() {

    init {
        items = mutableListOf()
    }

    fun addDelegate(delegate :  AdapterDelegate<MutableList<Any>>) {
        delegatesManager.addDelegate(delegate)
    }

    fun addItemsFromStart(data : List<Any>) {
        items.addAll(0, data)
        notifyItemRangeChanged(0, data.size)
    }

    fun removeItem(pos : Int) {
        items.removeAt(pos)
        notifyItemRemoved(pos)
    }

    fun addItem(pos : Int, item : Any) {
        items.add(pos, item)
        notifyItemInserted(pos)
    }

    fun addItem(item : Any) {
        items.add(item)
        notifyItemInserted(items.lastIndex)
    }

    fun addItems(addingItems : List<Any>) {
        items.addAll(addingItems)
        notifyItemRangeInserted(items.lastIndex - addingItems.lastIndex, items.lastIndex)
    }

    fun setData (data : List<Any>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
}
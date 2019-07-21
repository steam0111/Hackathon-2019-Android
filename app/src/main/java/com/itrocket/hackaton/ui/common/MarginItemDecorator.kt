package com.itrocket.hackaton.ui.common

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecorator(var left : Int = 0,
                          var top : Int = 0,
                          var right : Int = 0,
                          var bottom : Int = 0) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect,
                                view: View,
                                parent: RecyclerView,
                                state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = top
        }

        outRect.left = left
        outRect.right = right
        outRect.bottom = bottom
    }
}
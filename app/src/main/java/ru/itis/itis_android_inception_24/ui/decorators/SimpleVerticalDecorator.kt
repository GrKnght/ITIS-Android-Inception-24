package ru.itis.itis_android_inception_24.ui.decorators

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SimpleVerticalDecorator(private val marginValue: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val currentElemPosition = parent.getChildAdapterPosition(view)
        if (currentElemPosition == 0) return
        outRect.apply {
            left = marginValue
        }
    }
}
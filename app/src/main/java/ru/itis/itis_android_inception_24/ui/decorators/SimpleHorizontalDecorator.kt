package ru.itis.itis_android_inception_24.ui.decorators

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.itis.itis_android_inception_24.ui.viewholder.SecondTypeViewHolder

class SimpleHorizontalDecorator(
    private val marginValue: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val holder = parent.getChildViewHolder(view)
        if (holder is SecondTypeViewHolder) {
            outRect.apply {
                left = marginValue
                right = marginValue
            }
        }
    }
}
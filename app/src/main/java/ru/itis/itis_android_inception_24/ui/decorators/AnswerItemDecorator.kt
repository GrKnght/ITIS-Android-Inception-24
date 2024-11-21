package ru.itis.itis_android_inception_24.ui.decorators

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class AnswerItemDecorator(
    private val horizontalOffset: Int,
    private val verticalOffset: Int,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.apply {
            left = horizontalOffset
            right = horizontalOffset
            top = verticalOffset
            bottom = verticalOffset
        }
    }
}
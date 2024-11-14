package ru.itis.itis_android_inception_24.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import ru.itis.itis_android_inception_24.databinding.ItemSimpleTextBinding

class SimpleTextViewHolder(
    private val viewBinding: ItemSimpleTextBinding,
    onClick: () -> Unit,
) : RecyclerView.ViewHolder(viewBinding.root) {

    init {
        viewBinding.root.setOnClickListener {
            onClick()
        }
    }

    fun bindItem(text: String) {
        viewBinding.textSample.text = text
    }
}
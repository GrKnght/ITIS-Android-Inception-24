package ru.itis.itis_android_inception_24.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import ru.itis.itis_android_inception_24.databinding.ItemHolderButtonBinding

class ButtonTypeViewHolder(
    private val onClickAction: () -> Unit,
    viewBinding: ItemHolderButtonBinding,
) : RecyclerView.ViewHolder(viewBinding.root) {

    init {
        viewBinding.actionBtn.setOnClickListener {
            onClickAction()
        }
    }
}
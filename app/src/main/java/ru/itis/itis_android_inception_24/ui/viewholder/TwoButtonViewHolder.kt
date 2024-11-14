package ru.itis.itis_android_inception_24.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import ru.itis.itis_android_inception_24.databinding.ItemTwoButtonBinding

class TwoButtonViewHolder(
    onFirstButtonClick: () -> Unit,
    onSecondButtonClick: () -> Unit,
    viewBinding: ItemTwoButtonBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    init {
        viewBinding.firstButton.setOnClickListener {
            onFirstButtonClick()
        }
        viewBinding.secondButton.setOnClickListener {
            onSecondButtonClick()
        }
    }
}
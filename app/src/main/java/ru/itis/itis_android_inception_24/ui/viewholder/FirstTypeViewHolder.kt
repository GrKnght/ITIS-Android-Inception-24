package ru.itis.itis_android_inception_24.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.itis_android_inception_24.databinding.ItemHolderFirstTypeBinding
import ru.itis.itis_android_inception_24.model.FirstHolderData

class FirstTypeViewHolder(
    private val viewBinding: ItemHolderFirstTypeBinding,
    private val requestManager: RequestManager,
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindItem(itemData: FirstHolderData) {
        with(viewBinding) {
            headerTv.text = itemData.headerText
            requestManager.load(itemData.imageUrl)
                .into(pictureIv)
        }
    }
}
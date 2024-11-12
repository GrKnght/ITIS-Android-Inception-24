package ru.itis.itis_android_inception_24.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.itis_android_inception_24.databinding.ItemHolderSecondTypeBinding
import ru.itis.itis_android_inception_24.model.SecondHolderData

class SecondTypeViewHolder(
    private val viewBinding: ItemHolderSecondTypeBinding,
    private val requestManager: RequestManager,
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindItem(itemData: SecondHolderData) {
        with(viewBinding) {
            requestManager.load(itemData.imageUrl)
                .into(pictureIv)

            headerTv.text = itemData.headerText
            descTv.text = itemData.descText
        }
    }
}
package ru.itis.itis_android_inception_24.ui.viewholder

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.itis_android_inception_24.databinding.ItemRvWithPicBinding
import ru.itis.itis_android_inception_24.model.ListPictureItemModel

class ImageViewHolder(
    private val viewBinding: ItemRvWithPicBinding,
    private val requestManager: RequestManager,
    private val action: (Int) -> Unit
) : RecyclerView.ViewHolder(viewBinding.root) {

    init {
        viewBinding.root.setOnClickListener {
            action.invoke(adapterPosition)
        }
    }

    fun bindItem(itemData: ListPictureItemModel, count: Int) {
        viewBinding.descTv.text = itemData.description

        requestManager.load(itemData.imageUrl)
            .into(viewBinding.pictureIv)

        viewBinding.divider.isVisible = adapterPosition != count - 1


        // viewBinding.root.setBackgroundColor(itemData.background)
    }
}
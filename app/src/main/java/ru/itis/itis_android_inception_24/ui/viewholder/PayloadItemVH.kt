package ru.itis.itis_android_inception_24.ui.viewholder

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.databinding.ItemWithPayloadBinding
import ru.itis.itis_android_inception_24.model.ItemWithPictureModel

class PayloadItemVH(
    private val viewBinding: ItemWithPayloadBinding,
    private val requestManager: RequestManager,
    onIconClick: (Int) -> Unit
) : RecyclerView.ViewHolder(viewBinding.root) {

    init {
        viewBinding.favBtn.setOnClickListener {
            onIconClick(adapterPosition)
        }
    }

    fun bindItemData(data: ItemWithPictureModel) {
        requestManager.load(data.imageUrl).into(viewBinding.pictureIv)
        bindFavoriteIconState(data.isFavorite)

        viewBinding.descTv.text = data.description
//
//        requestManager.load(imageRes)
//            .load(viewBinding.favBtn)

    }

    fun bindFavoriteIconState(isFavorite: Boolean) {
        val imageRes = if (isFavorite) {
            R.drawable.ic_favorite_active
        } else {
            R.drawable.ic_favorite_inactive
        }

        val drawable = ContextCompat.getDrawable(itemView.context, imageRes)
        viewBinding.favBtn.setImageDrawable(drawable)
    }
}
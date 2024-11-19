package ru.itis.itis_android_inception_24.adapter.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.itis_android_inception_24.databinding.ItemWithPayloadBinding
import ru.itis.itis_android_inception_24.model.ItemWithPictureModel
import ru.itis.itis_android_inception_24.ui.viewholder.PayloadItemVH

@SuppressLint("NotifyDataSetChanged")
class ListContentAdapterWithPayload(
    private val requestManager: RequestManager,
    private val onIconClick: (Int) -> Unit,
    items: List<ItemWithPictureModel>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val dataList = mutableListOf<ItemWithPictureModel>()

    init {
        dataList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PayloadItemVH(
            viewBinding = ItemWithPayloadBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            requestManager = requestManager,
            onIconClick = onIconClick,
        )
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? PayloadItemVH)?.bindItemData(dataList[position])
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            when (payloads.first()) {
                is Boolean -> {
                    (holder as? PayloadItemVH)?.bindFavoriteIconState(isFavorite = payloads.first() as Boolean)
                }

                else -> {
                    super.onBindViewHolder(holder, position, payloads)
                }
            }
        }
    }

    override fun getItemCount(): Int = dataList.size
}
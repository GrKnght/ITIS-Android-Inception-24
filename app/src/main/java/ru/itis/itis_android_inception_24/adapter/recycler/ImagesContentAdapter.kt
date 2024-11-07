package ru.itis.itis_android_inception_24.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.itis_android_inception_24.databinding.ItemRvWithPicBinding
import ru.itis.itis_android_inception_24.model.ListPictureItemModel
import ru.itis.itis_android_inception_24.ui.viewholder.ImageViewHolder

class ImagesContentAdapter(
    private val requestManager: RequestManager,
    private val action: (Int) -> Unit,
    items: List<ListPictureItemModel>
) : RecyclerView.Adapter<ImageViewHolder>() {

    private val dataList = mutableListOf<ListPictureItemModel>()

    init {
        dataList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding =
            ItemRvWithPicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(
            viewBinding = binding,
            requestManager = requestManager,
            action = action
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindItem(itemData = dataList[position], itemCount)
    }

    override fun getItemCount(): Int = dataList.size

    fun updateItemBackground(color: Int, position: Int) {
        dataList[position].backgroundColor = color
        notifyItemChanged(position)
    }
}
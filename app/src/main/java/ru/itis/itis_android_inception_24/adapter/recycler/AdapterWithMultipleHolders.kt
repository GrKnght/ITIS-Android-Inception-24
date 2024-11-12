package ru.itis.itis_android_inception_24.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.databinding.ItemHolderFirstTypeBinding
import ru.itis.itis_android_inception_24.databinding.ItemHolderSecondTypeBinding
import ru.itis.itis_android_inception_24.model.FirstHolderData
import ru.itis.itis_android_inception_24.model.MultipleHoldersData
import ru.itis.itis_android_inception_24.model.SecondHolderData
import ru.itis.itis_android_inception_24.ui.viewholder.FirstTypeViewHolder
import ru.itis.itis_android_inception_24.ui.viewholder.SecondTypeViewHolder

class AdapterWithMultipleHolders(
    private val requestManager: RequestManager,
    items: List<MultipleHoldersData>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataList = mutableListOf<MultipleHoldersData>()

    init {
        dataList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_holder_first_type -> {
                FirstTypeViewHolder(
                    viewBinding = ItemHolderFirstTypeBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    requestManager = requestManager,
                )
            }

            R.layout.item_holder_second_type -> {
                SecondTypeViewHolder(
                    viewBinding = ItemHolderSecondTypeBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    requestManager = requestManager,
                )
            }

            else -> throw IllegalStateException("Unknown holder")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (dataList[position]) {
            is FirstHolderData -> {
                (holder as? FirstTypeViewHolder)?.bindItem(itemData = dataList[position] as FirstHolderData)
            }

            is SecondHolderData -> {
                (holder as? SecondTypeViewHolder)?.bindItem(itemData = dataList[position] as SecondHolderData)
            }

            else -> Unit
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        val item = dataList[position]
        return when (item) {
            is FirstHolderData -> {
                R.layout.item_holder_first_type
            }

            is SecondHolderData -> {
                R.layout.item_holder_second_type
            }

            else -> throw IllegalStateException("Incorrect holder type")
        }
    }
}
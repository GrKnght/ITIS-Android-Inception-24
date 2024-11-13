package ru.itis.itis_android_inception_24.utils

import androidx.recyclerview.widget.DiffUtil
import ru.itis.itis_android_inception_24.model.MultipleHoldersData
import ru.itis.itis_android_inception_24.model.SecondHolderData

class SampleDiffUtil(
    private val oldList: List<MultipleHoldersData>,
    private val newList: List<MultipleHoldersData>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        if (oldItem is SecondHolderData && newItem is SecondHolderData) {
            return oldItem.imageUrl == newItem.imageUrl
        }

        return oldItem.headerText == newItem.headerText
    }
}
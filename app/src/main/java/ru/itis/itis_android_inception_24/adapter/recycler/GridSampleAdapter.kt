package ru.itis.itis_android_inception_24.adapter.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.databinding.ItemSimpleTextBinding
import ru.itis.itis_android_inception_24.databinding.ItemTwoButtonBinding
import ru.itis.itis_android_inception_24.model.MultipleHoldersData
import ru.itis.itis_android_inception_24.model.SimpleTextHolderData
import ru.itis.itis_android_inception_24.model.TwoButtonHolderData
import ru.itis.itis_android_inception_24.ui.viewholder.SimpleTextViewHolder
import ru.itis.itis_android_inception_24.ui.viewholder.TwoButtonViewHolder

@SuppressLint("NotifyDataSetChanged")
class GridSampleAdapter(
    private val onFirstButtonClicked: () -> Unit,
    private val onSecondButtonClicked: () -> Unit,
    items: List<MultipleHoldersData>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataItems = mutableListOf<MultipleHoldersData>()

    init {
        dataItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_two_button -> {
                TwoButtonViewHolder(
                    viewBinding = ItemTwoButtonBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    onFirstButtonClick = onFirstButtonClicked,
                    onSecondButtonClick = onSecondButtonClicked,
                )
            }

            R.layout.item_simple_text -> {
                SimpleTextViewHolder(
                    viewBinding = ItemSimpleTextBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    onClick = {}
                )
            }

            else -> throw IllegalStateException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (dataItems[position]) {
            is SimpleTextHolderData -> {
                val data = dataItems[position] as SimpleTextHolderData
                (holder as? SimpleTextViewHolder)?.bindItem(data.text)
            }

            else -> Unit
        }
    }

    override fun getItemCount(): Int = dataItems.size

    override fun getItemViewType(position: Int): Int {
        return when (dataItems[position]) {
            is TwoButtonHolderData -> {
                R.layout.item_two_button
            }

            is SimpleTextHolderData -> {
                R.layout.item_simple_text
            }

            else -> throw IllegalStateException()
        }
    }
}
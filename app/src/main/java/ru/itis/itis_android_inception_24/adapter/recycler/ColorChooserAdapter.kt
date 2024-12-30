package ru.itis.itis_android_inception_24.adapter.recycler

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.itis.itis_android_inception_24.databinding.ItemColorChooserBinding
import ru.itis.itis_android_inception_24.model.ColorEnum

class ColorChooserAdapter(
    private val items: List<ColorEnum>,
    private val onClickAction: (res: ColorEnum) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemColorChooserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ColorChooserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ColorChooserViewHolder -> {
                holder.bindItemData(items[position])
            }

            else -> throw IllegalStateException("Unknown view holder type")
        }
    }

    override fun getItemCount(): Int = items.size

    private inner class ColorChooserViewHolder(
        private val viewBinding: ItemColorChooserBinding
    ) : RecyclerView.ViewHolder(viewBinding.root) {

        private var colorRes: ColorEnum? = null

        init {
            viewBinding.root.setOnClickListener {
                colorRes?.let(onClickAction::invoke)
            }
        }

        fun bindItemData(colorData: ColorEnum) {
            colorRes = colorData

            val bgColor = when (colorData) {
                ColorEnum.RED -> Color.RED

                ColorEnum.GREEN -> Color.GREEN

                ColorEnum.YELLOW -> Color.YELLOW
            }
            viewBinding.root.setBackgroundColor(bgColor)
        }
    }
}
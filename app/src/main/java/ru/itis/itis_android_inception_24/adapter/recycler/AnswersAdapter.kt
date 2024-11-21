package ru.itis.itis_android_inception_24.adapter.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.itis.itis_android_inception_24.databinding.ItemAnswerBinding
import ru.itis.itis_android_inception_24.model.AnswerModel

@SuppressLint("NotifyDataSetChanged")
class AnswersAdapter(
    private val onAnswerClick: (String) -> Unit,
    private val colors: Pair<Int, Int>,
    private var checkedAnswerId: String,
    items: List<AnswerModel>,
) : RecyclerView.Adapter<AnswersAdapter.AnswerViewHolder>() {

    private val dataList = mutableListOf<AnswerModel>()

    init {
        dataList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        return AnswerViewHolder(
            viewBinding = ItemAnswerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onAnswerClick = onAnswerClick,
        )
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        holder.bindItem(item = dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    inner class AnswerViewHolder(
        private val viewBinding: ItemAnswerBinding,
        onAnswerClick: (String) -> Unit,
    ) : RecyclerView.ViewHolder(viewBinding.root) {

        init {
            with(viewBinding) {
                root.setOnClickListener {
                    val previousPosition = dataList.indexOfFirst {
                        it.answerId == checkedAnswerId
                    }
                    val item = dataList[adapterPosition]
                    this@AnswersAdapter.checkedAnswerId = item.answerId
                    onAnswerClick(item.answerId)
                    notifyItemChanged(adapterPosition)
                    if (previousPosition != -1) {
                        notifyItemChanged(previousPosition)
                    }
                }
            }
        }

        fun bindItem(item: AnswerModel) {
            with(viewBinding) {
                answerTv.text = item.answerText
                val bgColor = if (checkedAnswerId == item.answerId) {
                    colors.second
                } else {
                    colors.first
                }
                contentContainer.setBackgroundColor(bgColor)
                radioBtn.isChecked = checkedAnswerId == item.answerId
                root.isEnabled = checkedAnswerId != item.answerId
            }
        }
    }
}
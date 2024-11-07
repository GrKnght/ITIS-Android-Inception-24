package ru.itis.itis_android_inception_24.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.itis.itis_android_inception_24.databinding.ItemListBinding

class ListContentAdapter(
    val action: () -> Unit
) : RecyclerView.Adapter<ListContentAdapter.ListContentViewHolder>() {

    var itemsList = mutableListOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListContentViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent)
//        return ListContentViewHolder(view)
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListContentViewHolder(viewBinding = binding)
    }

    override fun onBindViewHolder(holder: ListContentViewHolder, position: Int) {
        holder.bindItem(input = "someInput: $position : ${itemsList[position]}")
    }

    override fun getItemCount(): Int = itemsList.size

    fun updateItem(position: Int, item: String) {
        itemsList[position] = item
        notifyItemChanged(position)
    }

    inner class ListContentViewHolder(
        private val viewBinding: ItemListBinding
    ) : ViewHolder(viewBinding.root) {

        fun bindItem(input: String) {
            viewBinding.textTv.text = input
        }
    }
}
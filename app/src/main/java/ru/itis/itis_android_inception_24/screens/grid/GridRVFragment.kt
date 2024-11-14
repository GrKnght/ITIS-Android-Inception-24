package ru.itis.itis_android_inception_24.screens.grid

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.adapter.recycler.GridSampleAdapter
import ru.itis.itis_android_inception_24.databinding.FragmentGridrvBinding
import ru.itis.itis_android_inception_24.model.SimpleTextHolderData
import ru.itis.itis_android_inception_24.model.TwoButtonHolderData

class GridRVFragment : Fragment(R.layout.fragment_gridrv) {

    private val viewBinding by viewBinding(FragmentGridrvBinding::bind)

    private var rvAdapter: GridSampleAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvAdapter = GridSampleAdapter(
            items = listOf(
                TwoButtonHolderData("firstElem", "text"),
                SimpleTextHolderData(text = "Первый", "firstElem", "text"),
                SimpleTextHolderData(text = "Второй", "firstElem", "text"),
                SimpleTextHolderData(text = "Третий", "firstElem", "text"),
                SimpleTextHolderData(text = "Четвертый", "firstElem", "text"),
                SimpleTextHolderData(text = "Пятый", "firstElem", "text"),
                SimpleTextHolderData(text = "Шестой", "firstElem", "text"),
                SimpleTextHolderData(text = "Седьмой", "firstElem", "text"),
                SimpleTextHolderData(text = "Восьмой", "firstElem", "text"),
                SimpleTextHolderData(text = "Девятый", "firstElem", "text"),
                SimpleTextHolderData(text = "Десятый", "firstElem", "text"),
                SimpleTextHolderData(text = "Одиннадцатый", "firstElem", "text"),
                SimpleTextHolderData(text = "Двенадцатый", "firstElem", "text"),
                SimpleTextHolderData(text = "Тринадцатый", "firstElem", "text"),
                SimpleTextHolderData(text = "Четырнадцатый", "firstElem", "text"),
                SimpleTextHolderData(text = "Пятнадцатый", "firstElem", "text"),
                SimpleTextHolderData(text = "Шестнадцатый", "firstElem", "text"),
                SimpleTextHolderData(text = "Семнадцатый", "firstElem", "text"),
                SimpleTextHolderData(text = "Восемнадцатый", "firstElem", "text"),
            ),
            onFirstButtonClicked = {
                val manager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
                viewBinding.gridRecycler.layoutManager = manager
            },
            onSecondButtonClicked = {
                val manager = GridLayoutManager(requireContext(), 3, RecyclerView.VERTICAL, false)
                manager.spanSizeLookup = object : SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return when (position) {
                            0 -> 3
                            else -> 1
                        }
                    }
                }
                viewBinding.gridRecycler.layoutManager = manager
            }
        )
        viewBinding.gridRecycler.apply {
            val manager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            layoutManager = manager

            adapter = rvAdapter
        }
    }
}
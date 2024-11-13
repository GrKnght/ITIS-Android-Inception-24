package ru.itis.itis_android_inception_24.screens.multipleTypesList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.adapter.recycler.AdapterWithMultipleHolders
import ru.itis.itis_android_inception_24.databinding.FragmentMultipleTypesRvBinding
import ru.itis.itis_android_inception_24.model.SecondHolderData
import ru.itis.itis_android_inception_24.repository.ScreensContentRepository
import ru.itis.itis_android_inception_24.ui.decorators.SimpleHorizontalDecorator
import ru.itis.itis_android_inception_24.utils.getValueInDp

class MultipleTypesFragment : Fragment(R.layout.fragment_multiple_types_rv) {

    private val viewBinding by viewBinding(FragmentMultipleTypesRvBinding::bind)

    private var rvAdapter: AdapterWithMultipleHolders? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initViews()
    }

    private fun initRecyclerView() {
        rvAdapter = AdapterWithMultipleHolders(
            requestManager = Glide.with(requireContext()),
            onButtonClick = ::onButtonClick,
            items = ScreensContentRepository.getListForMultipleTypes(),
        )
        with(viewBinding) {
            mainRecycler.adapter = rvAdapter
            mainRecycler.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

            mainRecycler.addItemDecoration(
                SimpleHorizontalDecorator(
                    marginValue = getValueInDp(value = 16f, requireContext()).toInt()
                )
            )
        }
    }

    private fun onButtonClick() {
        val list = ScreensContentRepository.getListForMultipleTypes().toMutableList()
        list[4] = SecondHolderData(
            id = "fifth_id",
            headerText = "Hello from elem",
            descText = "some description text to sample",
            imageUrl = "https://dwglogo.com/wp-content/uploads/2019/09/1400px-Android_logo_2019.png",
        )
        list[7] = SecondHolderData(
            id = "seventh_id",
            headerText = "Hello from elem",
            descText = "some description text to sample",
            imageUrl = "https://dwglogo.com/wp-content/uploads/2019/09/1400px-Android_logo_2019.png",
        )
        list[9] = SecondHolderData(
            id = "ninth_id",
            headerText = "Hello from elem",
            descText = "some description text to sample",
            imageUrl = "https://dwglogo.com/wp-content/uploads/2019/09/1400px-Android_logo_2019.png",
        )
        rvAdapter?.updateData(list)
    }

    private fun initViews() {}
}
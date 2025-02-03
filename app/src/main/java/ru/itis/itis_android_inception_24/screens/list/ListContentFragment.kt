package ru.itis.itis_android_inception_24.screens.list

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.adapter.recycler.ImagesContentAdapter
import ru.itis.itis_android_inception_24.databinding.FragmentListContentBinding
import ru.itis.itis_android_inception_24.data.db.repository.ScreensContentRepository
import ru.itis.itis_android_inception_24.ui.decorators.SimpleHorizontalDecorator
import ru.itis.itis_android_inception_24.utils.getValueInDp
import kotlin.random.Random

class ListContentFragment : Fragment(R.layout.fragment_list_content) {

    private val viewBinding: FragmentListContentBinding by viewBinding(FragmentListContentBinding::bind)

    private var rvAdapter: ImagesContentAdapter? = null

    private val colorsList = listOf(
        R.color.purple_200,
        R.color.purple_500,
        R.color.purple_700,
        R.color.teal_200,
        R.color.teal_700,
        R.color.green_200,
        R.color.green_500,
        R.color.green_700,
        R.color.yellow_200,
        R.color.yellow_500,
        R.color.yellow_700
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val glide = Glide.with(requireContext())
        initRecyclerView(requestManager = glide)

        with(viewBinding) {
            glide
                .load("https://ih1.redbubble.net/image.5494804801.8633/bg,f8f8f8-flat,750x,075,f-pad,750x1000,f8f8f8.jpg")
                .into(headerIv)
        }
    }

    private fun initRecyclerView(requestManager: RequestManager) {
        val dataList =
            ScreensContentRepository.getListContentScreenInitialData(ctx = requireContext())
        rvAdapter = ImagesContentAdapter(
            requestManager = requestManager,
            action = ::onItemClick,
            items = dataList
        )
        with(viewBinding) {
            mainRecycler.adapter = rvAdapter

            mainRecycler.addItemDecoration(
                SimpleHorizontalDecorator(
                    marginValue = getValueInDp(value = 16f, requireContext()).toInt()
                )
            )
            mainRecycler.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    RecyclerView.VERTICAL
                )
            )
        }
    }

    private fun onItemClick(position: Int) {
        val randomInt = Random.nextInt(0, colorsList.size)
        rvAdapter?.updateItemBackground(
            ContextCompat.getColor(
                requireContext(),
                colorsList[randomInt]
            ),
            position
        )
    }
}
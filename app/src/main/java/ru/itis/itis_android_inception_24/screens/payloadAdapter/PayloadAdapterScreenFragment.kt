package ru.itis.itis_android_inception_24.screens.payloadAdapter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.adapter.recycler.ListContentAdapterWithPayload
import ru.itis.itis_android_inception_24.databinding.FragmentDefaultRvBinding
import ru.itis.itis_android_inception_24.model.ItemWithPictureModel

class PayloadAdapterScreenFragment : Fragment(R.layout.fragment_default_rv) {

    private val viewBinding: FragmentDefaultRvBinding by viewBinding(FragmentDefaultRvBinding::bind)

    private var rvAdapter: ListContentAdapterWithPayload? = null

    private var glide: RequestManager? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        glide = Glide.with(requireContext())
        rvAdapter = ListContentAdapterWithPayload(
            requestManager = glide ?: throw IllegalStateException(),
            onIconClick = { position ->
                rvAdapter?.let {
                    val currentState = !it.dataList[position].isFavorite
                    it.dataList[position].isFavorite = currentState
                    rvAdapter?.notifyItemChanged(position, currentState)
                }
            },
            items = listOf(
                ItemWithPictureModel(
                    id = "first",
                    imageUrl = "https://cdn.apollo.audio/one/media/66da/d047/4928/f305/a20b/b9f1/films-released-2024-movies-release-dates.jpg?quality=80&format=jpg&crop=0,0,1033,1838&resize=crop",
                    description = "someDesc"
                ),
                ItemWithPictureModel(
                    id = "second",
                    imageUrl = "https://cdn.theatlantic.com/thumbor/yPmbM7GaxZyu6jG-Yfxv7AeNKLo=/0x0:2880x1620/960x540/media/img/mt/2024/09/fall_movies-1/original.jpgl",
                    description = "someDesc"
                ),
                ItemWithPictureModel(
                    id = "third",
                    imageUrl = "https://www.americamagazine.org/sites/default/files/main_image/Top%2025%20Films%20FINAL.png",
                    description = "someDesc"
                ),
                ItemWithPictureModel(
                    id = "first",
                    imageUrl = "https://cdn.apollo.audio/one/media/66da/d047/4928/f305/a20b/b9f1/films-released-2024-movies-release-dates.jpg?quality=80&format=jpg&crop=0,0,1033,1838&resize=crop",
                    description = "someDesc"
                ),
                ItemWithPictureModel(
                    id = "second",
                    imageUrl = "https://cdn.theatlantic.com/thumbor/yPmbM7GaxZyu6jG-Yfxv7AeNKLo=/0x0:2880x1620/960x540/media/img/mt/2024/09/fall_movies-1/original.jpgl",
                    description = "someDesc"
                ),
                ItemWithPictureModel(
                    id = "third",
                    imageUrl = "https://www.americamagazine.org/sites/default/files/main_image/Top%2025%20Films%20FINAL.png",
                    description = "someDesc"
                ),
                ItemWithPictureModel(
                    id = "first",
                    imageUrl = "https://cdn.apollo.audio/one/media/66da/d047/4928/f305/a20b/b9f1/films-released-2024-movies-release-dates.jpg?quality=80&format=jpg&crop=0,0,1033,1838&resize=crop",
                    description = "someDesc"
                ),
                ItemWithPictureModel(
                    id = "second",
                    imageUrl = "https://cdn.theatlantic.com/thumbor/yPmbM7GaxZyu6jG-Yfxv7AeNKLo=/0x0:2880x1620/960x540/media/img/mt/2024/09/fall_movies-1/original.jpgl",
                    description = "someDesc"
                ),
                ItemWithPictureModel(
                    id = "third",
                    imageUrl = "https://www.americamagazine.org/sites/default/files/main_image/Top%2025%20Films%20FINAL.png",
                    description = "someDesc"
                ),
            )
        )
        viewBinding.mainRecycler.adapter = rvAdapter
    }
}
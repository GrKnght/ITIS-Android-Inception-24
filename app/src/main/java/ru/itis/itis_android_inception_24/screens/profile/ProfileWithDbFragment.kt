package ru.itis.itis_android_inception_24.screens.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.launch
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.data.db.entities.FilmEntity
import ru.itis.itis_android_inception_24.data.db.entities.PetEntity
import ru.itis.itis_android_inception_24.data.db.entities.UserEntity
import ru.itis.itis_android_inception_24.databinding.FragmentProfileBinding
import ru.itis.itis_android_inception_24.di.ServiceLocator
import java.util.UUID

class ProfileWithDbFragment : Fragment(R.layout.fragment_profile) {

    private val userRepository = ServiceLocator.getUserRepository()

    private val viewBinding by viewBinding(FragmentProfileBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = UserEntity(
            id = "user_id_1",
            firstName = "Max",
            secondName = "Payne",
            address = "New York"
        )

        val filmsList = listOf(
            FilmEntity(
                id = "film_id_1",
                userId = "user_id_1",
                filmName = "Inception",
                releaseDate = "2005",
                rating = 8.5f,
                description = null,
            ),
            FilmEntity(
                id = "film_id_2",
                userId = "user_id_1",
                filmName = "Inception 2",
                releaseDate = "2005",
                rating = 8.5f,
                description = null,
            ),
            FilmEntity(
                id = "film_id_3",
                userId = "user_id_1",
                filmName = "Inception 3",
                releaseDate = "2005",
                rating = 8.5f,
                description = null,
            )
        )

        val pet = PetEntity(
            id = "pet_id_1",
            name = "PetName",
            userId = "user_id_1"
        )

        lifecycleScope.launch {
            userRepository.saveUser(user)
            userRepository.savePet(pet)
            userRepository.saveFilms(filmsList)
            userRepository.getUsersAndPets()?.let { dataList ->
                if (dataList.isNotEmpty()) {
                    viewBinding.sampleTv.text = dataList.first().pet.name
                }
            }
        }
    }
}
package ru.itis.itis_android_inception_24.screens.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.itis.itis_android_inception_24.App
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.data.InceptionDatabase
import ru.itis.itis_android_inception_24.data.entities.UserEntity
import ru.itis.itis_android_inception_24.data.repository.UserRepository
import java.util.UUID

class ProfileWithDbFragment : Fragment(R.layout.fragment_profile) {

    private var db: InceptionDatabase? = null

    private var userRepository: UserRepository? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = (requireActivity().application as? App)?.getDatabase()

        db?.let {
            userRepository = UserRepository(userDao = it.userDao)

            val user = UserEntity(
                id = UUID.randomUUID().toString(),
                firstName = "Max",
                secondName = "Payne",
                address = "New York"
            )

            lifecycleScope.launch {
                userRepository?.saveUser(user)
            }
        }
    }
}
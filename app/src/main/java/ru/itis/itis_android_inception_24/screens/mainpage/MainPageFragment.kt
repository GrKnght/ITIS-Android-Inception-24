package ru.itis.itis_android_inception_24.screens.mainpage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment(R.layout.fragment_main_page) {

    private val viewBinding: FragmentMainPageBinding by viewBinding(FragmentMainPageBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        const val TAG = "MAIN_PAGE"
    }
}
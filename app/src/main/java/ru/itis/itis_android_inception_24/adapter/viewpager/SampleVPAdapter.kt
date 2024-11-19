package ru.itis.itis_android_inception_24.adapter.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.itis.itis_android_inception_24.screens.questionnaire.QuestionnaireFragment

class SampleVPAdapter(
    manager: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(manager, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        return QuestionnaireFragment.getInstance(position)
    }

    override fun getItemCount(): Int = 10
}
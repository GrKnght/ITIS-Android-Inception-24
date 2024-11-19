package ru.itis.itis_android_inception_24.screens.questionnaire

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.databinding.FragmentQuestionnaireBinding

class QuestionnaireFragment : Fragment(R.layout.fragment_questionnaire) {

    private val viewBinding: FragmentQuestionnaireBinding by viewBinding(
        FragmentQuestionnaireBinding::bind
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt(POSITION_KEY)?.let { position ->
            val question: String
            val answer1: String
            val answer2: String
            when (position) {
                0 -> {
                    question = "First"
                    answer1 = "Second"
                    answer2 = "Third"
                }

                1 -> {
                    question = "First1"
                    answer1 = "Second1"
                    answer2 = "Third1"
                }

                2 -> {
                    question = "First1"
                    answer1 = "Second1"
                    answer2 = "Third1"
                }

                3 -> {
                    question = "First1"
                    answer1 = "Second1"
                    answer2 = "Third1"
                }

                else -> {
                    question = "First5"
                    answer1 = "Second5"
                    answer2 = "Third5"
                }
            }

            with(viewBinding) {
                questionTv.text = question
                answer1Tv.text = answer1
                answer2Tv.text = answer2
            }
        }
    }

    companion object {
        private const val POSITION_KEY = "POSITION"

        fun getInstance(position: Int) = QuestionnaireFragment().apply {
            arguments = bundleOf(POSITION_KEY to position)
        }
    }
}
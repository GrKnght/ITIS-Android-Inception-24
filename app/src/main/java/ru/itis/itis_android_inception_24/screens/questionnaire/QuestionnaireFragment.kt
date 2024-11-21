package ru.itis.itis_android_inception_24.screens.questionnaire

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.adapter.recycler.AnswersAdapter
import ru.itis.itis_android_inception_24.databinding.FragmentQuestionnaireBinding
import ru.itis.itis_android_inception_24.model.QuestionModel
import ru.itis.itis_android_inception_24.ui.decorators.AnswerItemDecorator
import ru.itis.itis_android_inception_24.utils.getParcelableSafe
import ru.itis.itis_android_inception_24.utils.getValueInDp

class QuestionnaireFragment : Fragment(R.layout.fragment_questionnaire) {

    private val viewBinding by viewBinding(FragmentQuestionnaireBinding::bind)

    private var rvAdapter: AnswersAdapter? = null

    private var questionId: String? = null

    var onAnswerClickedCallback: ((String, String) -> Unit)? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelableSafe<QuestionModel>(QUESTION_MODEL_KEY)?.let { question ->
            questionId = question.questionId
            viewBinding.questionTv.text = question.questionText
            rvAdapter = AnswersAdapter(
                onAnswerClick = ::onAnswerClicked,
                colors = Pair(
                    ContextCompat.getColor(requireContext(), R.color.white),
                    ContextCompat.getColor(requireContext(), R.color.green_200_25a)
                ),
                checkedAnswerId = question.answerId.orEmpty(),
                items = question.answers,
            )
            val decorator = AnswerItemDecorator(
                horizontalOffset = getValueInDp(16f, requireContext()).toInt(),
                verticalOffset = getValueInDp(4f, requireContext()).toInt(),
            )
            viewBinding.answersRv.adapter = rvAdapter
            viewBinding.answersRv.addItemDecoration(decorator)
        }
    }

    private fun onAnswerClicked(answerId: String) {
        questionId?.let { id ->
            onAnswerClickedCallback?.invoke(id, answerId)
        }
    }

    companion object {
        private const val QUESTION_MODEL_KEY = "QUESTION_MODEL"

        fun getInstance(questions: QuestionModel) =
            QuestionnaireFragment().apply {
                arguments = bundleOf(QUESTION_MODEL_KEY to questions)
            }
    }
}
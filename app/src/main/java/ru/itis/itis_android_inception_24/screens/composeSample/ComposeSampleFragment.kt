package ru.itis.itis_android_inception_24.screens.composeSample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.base.BaseFragment
import ru.itis.itis_android_inception_24.databinding.FragmentComposeSampleBinding
import ru.itis.itis_android_inception_24.model.AnswerModel
import ru.itis.itis_android_inception_24.screens.composeSample.ui.ComposeListSample
import ru.itis.itis_android_inception_24.screens.composeSample.ui.HeaderTextInput

class ComposeSampleFragment : BaseFragment(R.layout.fragment_compose_sample) {

    private val viewBinding by viewBinding(FragmentComposeSampleBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val composeView = ComposeView(requireContext())
        val view = inflater.inflate(R.layout.fragment_compose_sample, container ,false)
        (view as? ViewGroup)?.addView(composeView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.composeContainerId.setContent {
            Scaffold(
                topBar = { HeaderTextInput() }
            ) { padding ->
                Column {
                    Text(
                        text = stringResource(R.string.chooser_title),
                        color = colorResource(R.color.teal_200),
                        fontSize = 32.sp,
                    )
                    val listState = rememberLazyListState()
                    val answersList = listOf(
                        AnswerModel(
                            answerId = "First",
                            answerText = "Second",
                        ),
                        AnswerModel(
                            answerId = "Third",
                            answerText = "Fourth",
                        ),
                        AnswerModel(
                            answerId = "First",
                            answerText = "Second",
                        ),
                        AnswerModel(
                            answerId = "Third",
                            answerText = "Fourth",
                        ),
                        AnswerModel(
                            answerId = "First",
                            answerText = "Second",
                        ),
                        AnswerModel(
                            answerId = "Third",
                            answerText = "Fourth",
                        ), AnswerModel(
                            answerId = "First",
                            answerText = "Second",
                        ),
                        AnswerModel(
                            answerId = "Third",
                            answerText = "Fourth",
                        )
                    )
                    ComposeListSample(
                        listState = listState,
                        items = answersList,
                    )
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        composeView = null
    }
}
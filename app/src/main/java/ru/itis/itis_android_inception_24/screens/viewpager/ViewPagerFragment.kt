package ru.itis.itis_android_inception_24.screens.viewpager

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.adapter.viewpager.SampleVPAdapter
import ru.itis.itis_android_inception_24.databinding.FragmentViewPagerBinding
import ru.itis.itis_android_inception_24.data.repository.ScreensContentRepository

class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    private val viewBinding: FragmentViewPagerBinding by viewBinding(FragmentViewPagerBinding::bind)

    private var vpAdapter: SampleVPAdapter? = null

    private var answeredQuestionsMap = mutableMapOf<String, String>()

    private val questionsCount = 12

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager(questionsCount)
        initViews()
    }

    private fun initViewPager(questionsCount: Int) {
        vpAdapter = SampleVPAdapter(
            items = ScreensContentRepository.getQuestionnaireList(questionsCount = questionsCount)
                .toMutableList(),
            onItemSelectedCallback = ::onAnswerClick,
            manager = parentFragmentManager,
            lifecycle = this.lifecycle,
        )
        viewBinding.contentVp.apply {
            adapter = vpAdapter
            registerOnPageChangeCallback(object : OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    with(viewBinding) {
                        questionNumberTv.text = "${position + 1}/$questionsCount"
                        nextQuestionBtn.isEnabled = position != questionsCount - 1
                        previousQuestionBtn.isEnabled = position != 0
                        sendResultBtn.isVisible = position == questionsCount - 1
                    }
                }
            })
        }
    }

    private fun onAnswerClick(questionId: String, answerId: String) {
        val questionPosition =
            vpAdapter?.items?.indexOfFirst { it.questionId == questionId } ?: return
        if (questionPosition != -1) {
            answeredQuestionsMap[questionId] = answerId
            vpAdapter?.items?.get(questionPosition)?.answerId = answerId
            if (answeredQuestionsMap.size == questionsCount) {
                viewBinding.sendResultBtn.isEnabled = true
            }
        }
    }

    private fun initViews() {
        with(viewBinding) {
            nextQuestionBtn.setOnClickListener {
                contentVp.currentItem += 1
            }
            previousQuestionBtn.setOnClickListener {
                contentVp.currentItem -= 1
            }
            sendResultBtn.setOnClickListener {
                val snackBar = Snackbar.make(
                    requireContext(),
                    viewBinding.root,
                    "Результаты сохранены",
                    Snackbar.LENGTH_SHORT
                ).setAnchorView(sendResultBtn)
                snackBar.show()
            }
        }
    }
}
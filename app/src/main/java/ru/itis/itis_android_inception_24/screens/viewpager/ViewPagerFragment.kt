package ru.itis.itis_android_inception_24.screens.viewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.adapter.viewpager.SampleVPAdapter
import ru.itis.itis_android_inception_24.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    private val viewBinding: FragmentViewPagerBinding by viewBinding(FragmentViewPagerBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SampleVPAdapter(
            manager = parentFragmentManager,
            lifecycle = this.lifecycle,
        )
        viewBinding.contentVp.adapter = adapter
    }
}
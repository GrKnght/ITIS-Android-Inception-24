package ru.itis.itis_android_inception_24.screens.init

import android.content.ContextWrapper
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.itis_android_inception_24.MainActivity
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.databinding.FragmentInitBinding

class InitFragment : Fragment(R.layout.fragment_init) {

    private val viewBinding: FragmentInitBinding by viewBinding(FragmentInitBinding::bind)

    //    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        viewBinding = FragmentInitBinding.inflate(inflater, container, false)
//        return viewBinding?.root
//    }
//
//    override fun onDestroyView() {
//        viewBinding = null
//        super.onDestroyView()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firstParam = arguments?.getString(FIRST_ARG_KEY) ?: return
        initViews(firstParam)
        val secondParam = arguments?.getString(SECOND_ARG_KEY) ?: return
        viewBinding.headerTv.text = "$firstParam:$secondParam"

        arguments?.getInt(ROOT_BG_KEY)?.let { colorRes ->
            val color = ContextCompat.getColor(requireContext(), colorRes)
            viewBinding.root.setBackgroundColor(color)
        }
    }

    private fun initViews(firstParam: String) {
        with(viewBinding) {
            actionBtn.setOnClickListener {
                (requireActivity() as? MainActivity)?.doSomeLogic(TAG)
            }

            if (firstParam == "firstStr") {
                sendImplicitIntentBtn.setOnClickListener {
                    Toast.makeText(requireContext(), "Bottom fragment", Toast.LENGTH_SHORT).show()
                }
            } else {
                sendImplicitIntentBtn.isInvisible = true
            }
        }
    }

    companion object {
        const val TAG = "INIT_FRAGMENT"

        private const val FIRST_ARG_KEY = "FIRST_ARG"
        private const val SECOND_ARG_KEY = "SECOND_ARG"
        private const val ROOT_BG_KEY = "ROOT_BG"

        fun getInstance(
            param1: String,
            param2: String,
            fragmentBg: Int,
        ): InitFragment {
//            val bundle = Bundle()
//            bundle.putString("FIRST_ARG_KEY", param1)
//            bundle.putString("SECOND_ARG_KEY", param2)
//            return InitFragment().apply {
//                arguments = bundle
//            }
            return InitFragment().apply {
                arguments = bundleOf(
                    FIRST_ARG_KEY to param1,
                    SECOND_ARG_KEY to param2,
                    ROOT_BG_KEY to fragmentBg,
                )
            }
        }
    }
}
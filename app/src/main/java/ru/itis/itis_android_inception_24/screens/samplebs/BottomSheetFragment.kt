package ru.itis.itis_android_inception_24.screens.samplebs

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.itis.itis_android_inception_24.R

class BottomSheetFragment : BottomSheetDialogFragment(R.layout.dialog_bottom_sheet) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        const val TAG = "BOTTOM_SHEET"
    }
}
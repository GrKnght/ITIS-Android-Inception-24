package ru.itis.itis_android_inception_24.screens.profile

import android.app.NotificationManager
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import ru.itis.itis_android_inception_24.MainActivity
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.adapter.recycler.ColorChooserAdapter
import ru.itis.itis_android_inception_24.databinding.FragmentProfileBinding
import ru.itis.itis_android_inception_24.model.ColorEnum
import ru.itis.itis_android_inception_24.model.NotificationData
import ru.itis.itis_android_inception_24.model.NotificationType
import ru.itis.itis_android_inception_24.ui.decorators.SimpleVerticalDecorator
import ru.itis.itis_android_inception_24.utils.getValueInDp

class ProfileSampleFragment : Fragment(R.layout.fragment_profile) {

    private val viewBinding by viewBinding(FragmentProfileBinding::bind)

    private var isCardViewExpanded: Boolean = false

    private var isPictureLoaded: Boolean = false

    private var rvAdapter: ColorChooserAdapter? = null

    private var notificationImportance: Int = NotificationManager.IMPORTANCE_MAX

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initRecyclerView()
    }

    private fun initViews() {
        with(viewBinding) {
            val typedValue = TypedValue()
            requireActivity().theme.resolveAttribute(
                com.google.android.material.R.attr.colorPrimary,
                typedValue,
                true
            )
            cancelBtn.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    typedValue.resourceId
                )
            )
            cancelBtn.setOnClickListener {
                profileLogoIv.setImageResource(0)
                isPictureLoaded = !isPictureLoaded
                cancelBtn.isVisible = isPictureLoaded
            }

            profileLogoIv.setOnClickListener {
                if (!isPictureLoaded) {
                    Glide.with(this@ProfileSampleFragment)
                        .load("https://images.theconversation.com/files/521751/original/file-20230419-18-hg9dc3.jpg")
                        .into(profileLogoIv)
                    isPictureLoaded = !isPictureLoaded
                    cancelBtn.isVisible = isPictureLoaded
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Изображение уже загружено",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            expandBtn.setOnClickListener {
                val rotationAngle = if (isCardViewExpanded) 0f else 180f

                val params = FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    if (isCardViewExpanded) FrameLayout.LayoutParams.WRAP_CONTENT else getValueInDp(
                        104f,
                        requireContext()
                    ).toInt()
                )
                val bias = if (isCardViewExpanded) .5f else 0f
                (expandBtn.layoutParams as? ConstraintLayout.LayoutParams)?.verticalBias = bias
                colorsRv.isVisible = !isCardViewExpanded
                isCardViewExpanded = !isCardViewExpanded
                expandBtn.rotation = rotationAngle
                innerContainer.layoutParams = params
            }
            resetColorBtn.setOnClickListener {
                requireActivity().intent.putExtra("theme_color", -1)
                requireActivity().recreate()
            }

            val arrayAdapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.notification_importance,
                android.R.layout.simple_spinner_item
            ).apply {
                setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            }
            importanceDropdown.adapter = arrayAdapter
            importanceDropdown.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    p1: View?,
                    position: Int,
                    p3: Long
                ) {
                    notificationImportance = when (position) {
                        0 -> NotificationManager.IMPORTANCE_MAX

                        1 -> NotificationManager.IMPORTANCE_HIGH

                        2 -> NotificationManager.IMPORTANCE_DEFAULT

                        else -> NotificationManager.IMPORTANCE_LOW
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }

            showNotificationBtn.setOnClickListener {
                if (firstTextInputEt.text?.isEmpty() == true) {
                    Toast.makeText(
                        requireContext(),
                        "Заголовок уведомления пустой",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }

                if (secondTextInputEt.text?.isEmpty() == true) {
                    Toast.makeText(requireContext(), "Текст уведомления пустой", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }

                (requireActivity() as? MainActivity)?.notificationsHandler?.showNotification(
                    data = NotificationData(
                        id = 1,
                        title = firstTextInputEt.text.toString(),
                        message = secondTextInputEt.text.toString(),
                        notificationType = when (notificationImportance) {
                            NotificationManager.IMPORTANCE_MAX -> NotificationType.URGENT

                            NotificationManager.IMPORTANCE_HIGH -> NotificationType.PRIVATE

                            NotificationManager.IMPORTANCE_DEFAULT -> NotificationType.DEFAULT

                            else -> NotificationType.LOW
                        },
                    )
                )
            }
        }
    }

    private fun initRecyclerView() {
        if (rvAdapter == null) {
            rvAdapter =
                ColorChooserAdapter(
                    items = listOf(ColorEnum.RED, ColorEnum.GREEN, ColorEnum.YELLOW),
                    onClickAction = ::onColorResClicked,
                )
            val itemDecorator =
                SimpleVerticalDecorator(marginValue = getValueInDp(8f, requireContext()).toInt())

            viewBinding.colorsRv.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            viewBinding.colorsRv.addItemDecoration(itemDecorator)
            viewBinding.colorsRv.adapter = rvAdapter
        }
    }

    private fun onColorResClicked(color: ColorEnum) {
        val colorRes = when (color) {
            ColorEnum.RED -> {
                3
            }

            ColorEnum.GREEN -> {
                2
            }

            ColorEnum.YELLOW -> {
                1
            }
        }
        requireActivity().intent.putExtra("theme_color", colorRes)
        requireActivity().recreate()
    }
}
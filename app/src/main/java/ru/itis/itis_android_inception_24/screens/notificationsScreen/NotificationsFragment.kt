package ru.itis.itis_android_inception_24.screens.notificationsScreen

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.itis.itis_android_inception_24.MainActivity
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.base.BaseFragment
import ru.itis.itis_android_inception_24.databinding.FragmentNotificationsBinding
import ru.itis.itis_android_inception_24.data.db.repository.ScreensContentRepository
import ru.itis.itis_android_inception_24.utils.NotificationsHandler

class NotificationsFragment : BaseFragment(R.layout.fragment_notifications) {

    private val viewBinding by viewBinding(FragmentNotificationsBinding::bind)

    private var notificationsHandler: NotificationsHandler? = null

    private var dataList: MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (notificationsHandler == null) {
            notificationsHandler = (requireActivity() as? MainActivity)?.notificationsHandler
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        notificationsHandler = null
    }

    private var counter = 0

    private fun initViews() {
        with(viewBinding) {
            showNotificationBtn.setOnClickListener {
//                notificationsHandler?.showNotification(
//                    data = NotificationData(
//                        id = ++counter,
//                        title = "Sample Title $counter",
//                        message = "Sample message $counter",
//                        notificationType = NotificationType.DEFAULT,
//                    )
//                )
                lifecycleScope.launch {
                    viewBinding.progressContainer.isVisible = true
                    runCatching {
                        withContext(Dispatchers.IO) {
                            ScreensContentRepository.getUserData()
                        }
                    }.onSuccess { userData ->
                        viewBinding.progressContainer.isVisible = false
                        dataList?.clear()
                        dataList?.addAll(userData)
                        descriptionTv.text = dataList?.first()?.plus(dataList?.last())
                    }.onFailure { ex ->
                        val errorText = when (ex) {
                            is IllegalStateException -> {
                                "Illegal state exception"
                            }

                            else -> {
                               "Other exception occurred"
                            }
                        }
                        Log.e(LOG_TAG, errorText)
                    }
                }
            }
        }
    }

    private companion object {
        const val LOG_TAG = "NOTIFICATION_FRAGMENT"
    }
}
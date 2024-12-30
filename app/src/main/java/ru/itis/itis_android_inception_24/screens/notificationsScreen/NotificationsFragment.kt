package ru.itis.itis_android_inception_24.screens.notificationsScreen

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.itis_android_inception_24.MainActivity
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.base.BaseFragment
import ru.itis.itis_android_inception_24.databinding.FragmentNotificationsBinding
import ru.itis.itis_android_inception_24.model.NotificationData
import ru.itis.itis_android_inception_24.model.NotificationType
import ru.itis.itis_android_inception_24.utils.NotificationsHandler

class NotificationsFragment : BaseFragment(R.layout.fragment_notifications) {

    private val viewBinding by viewBinding(FragmentNotificationsBinding::bind)

    private var notificationsHandler: NotificationsHandler? = null

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
                notificationsHandler?.showNotification(
                    data = NotificationData(
                        id = ++counter,
                        title = "Sample Title $counter",
                        message = "Sample message $counter",
                        notificationType = NotificationType.DEFAULT,
                    )
                )
            }
        }
    }
}
package ru.itis.itis_android_inception_24.screens.notificationsScreen

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.base.BaseFragment
import ru.itis.itis_android_inception_24.databinding.FragmentNotificationsBinding
import ru.itis.itis_android_inception_24.utils.NotificationsHandler

class NotificationsFragment : BaseFragment(R.layout.fragment_notifications) {

    private val viewBinding by viewBinding(FragmentNotificationsBinding::bind)

    private var notificationsHandler: NotificationsHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().applicationContext?.let { appCtx ->
            if (notificationsHandler == null) {
                notificationsHandler = NotificationsHandler(appCtx = appCtx)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.showNotificationBtn.setOnClickListener {
            notificationsHandler?.showNotification("", 123)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        notificationsHandler = null
    }
}
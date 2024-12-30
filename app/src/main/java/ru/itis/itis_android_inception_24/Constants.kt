package ru.itis.itis_android_inception_24

import android.app.NotificationManager
import ru.itis.itis_android_inception_24.model.NotificationChannelData

object Constants {

    val notificationsChannelsData = listOf(
        NotificationChannelData(
            id = "default_channel_id",
            name = "Стандартный канал уведомлений",
            importance = NotificationManager.IMPORTANCE_DEFAULT,
        ),
        NotificationChannelData(
            id = "private_channel_id",
            name = "Приватный канал уведомлений",
            importance = NotificationManager.IMPORTANCE_HIGH,
        ),
        NotificationChannelData(
            id = "urgent_channel_id",
            name = "Акционный канал уведомлений",
            importance = NotificationManager.IMPORTANCE_MAX,
        ),
    )
}
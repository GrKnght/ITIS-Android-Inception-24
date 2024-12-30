package ru.itis.itis_android_inception_24.model

data class NotificationData(
    val id: Int,
    val title: String,
    val message: String?,
    val notificationType: NotificationType? = null,
)

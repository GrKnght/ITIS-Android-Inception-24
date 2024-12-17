package ru.itis.itis_android_inception_24.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import ru.itis.itis_android_inception_24.R

class NotificationsHandler(private val appCtx: Context) {

    private val notificationManager =
        appCtx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(channelId: String, notificationId: Int) {
        val notificationBuilder = NotificationCompat.Builder(appCtx, channelId)
            .setSmallIcon(R.drawable.ic_favorite_active)
            .setContentTitle("Заголовок уведомления")
            .setContentText("Просто текст уведомления")

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(channelId, "name", NotificationManager.IMPORTANCE_LOW)
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify("name", notificationId, notificationBuilder.build())
    }
}
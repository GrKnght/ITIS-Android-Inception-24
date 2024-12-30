package ru.itis.itis_android_inception_24.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.os.bundleOf
import ru.itis.itis_android_inception_24.Constants
import ru.itis.itis_android_inception_24.MainActivity
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.model.NotificationData
import ru.itis.itis_android_inception_24.model.NotificationType

class NotificationsHandler(private val appCtx: Context) {

    private val notificationManager =
        appCtx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationsChannelsIfNeeded()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationsChannelsIfNeeded() {
        Constants.notificationsChannelsData.forEach { channelData ->
            if (notificationManager.getNotificationChannel(channelData.id) == null) {
                val channel = with(channelData) {
                    NotificationChannel(id, name, importance)
                }
                notificationManager.createNotificationChannel(channel)
            }
        }
    }

    fun showNotification(data: NotificationData) {
        val index = when (data.notificationType) {
            NotificationType.PRIVATE -> {
                1
            }

            NotificationType.URGENT -> {
                2
            }

            NotificationType.LOW -> {
                3
            }

            else -> 0
        }
        val channelId = Constants.notificationsChannelsData[index].id

        val activityIntent = Intent(appCtx, MainActivity::class.java).apply {
            action = Intent.ACTION_VIEW
            putExtra("notification_extra", 5)
        }
        val pendingIntent = PendingIntent.getActivity(
            appCtx,
            0,
            activityIntent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )
        val actionIntent = Intent(appCtx, MainActivity::class.java).apply {
            action = Intent.ACTION_VIEW

        }

        val notificationBuilder = NotificationCompat.Builder(appCtx, channelId)
            .setSmallIcon(R.drawable.ic_favorite_active)
            .setContentTitle(data.title)
            .setChannelId(channelId)
            .setContentIntent(pendingIntent)
//            .addAction(
//                R.drawable.ic_favorite_inactive, "Title", actionPendingIntent
//            )
            .setAutoCancel(true)

        data.message?.let { message ->
            notificationBuilder.setContentText(message)
        }

        notificationManager.notify(data.id, notificationBuilder.build())
    }

    fun cancelNotification(id: Int) {
        notificationManager.cancel(id)
    }
}
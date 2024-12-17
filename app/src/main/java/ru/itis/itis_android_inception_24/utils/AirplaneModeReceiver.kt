package ru.itis.itis_android_inception_24.utils

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AirplaneModeReceiver : BroadcastReceiver() {

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(ctx: Context?, intent: Intent?) {
        intent?.let { safeIntent ->
            val isAirplaneOn = safeIntent.getBooleanExtra("state", false)
            println("TEST TAG - AirplaneMode Changed: $isAirplaneOn")
        }
    }
}
package ru.itis.itis_android_inception_24.utils

import android.annotation.SuppressLint
import androidx.activity.result.contract.ActivityResultContracts
import ru.itis.itis_android_inception_24.MainActivity

class PermissionsHandler(
    private val activity: MainActivity,
    onSinglePermissionGranted: (() -> Unit)? = null,
    onSinglePermissionDenied: (() -> Unit)? = null,
    onMultiplePermissionGranted: (() -> Unit)? = null,
) {

    fun initContracts(mainActivity: MainActivity) {

    }

    private val singlePermissionResult =
        activity.registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                onSinglePermissionGranted?.invoke()
            } else {
                onSinglePermissionDenied?.invoke()
            }
        }

    @SuppressLint("InlinedApi")
    private val multiplePersmissionResult =
        activity.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { dataMap ->
            val isNotificationsGranted =
                dataMap[android.Manifest.permission.POST_NOTIFICATIONS] ?: false
            if (isNotificationsGranted) {
                onSinglePermissionGranted?.invoke()
            }
        }

    fun requestSinglePermission(permission: String) {
        singlePermissionResult.launch(permission)
    }

    fun requestMultiplePermissions(permission: List<String>) {
        multiplePersmissionResult.launch(permission.toTypedArray())
    }
}
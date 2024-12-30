package ru.itis.itis_android_inception_24.utils

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class PermissionsHandler(
    private val onSinglePermissionGranted: (() -> Unit)? = null,
    private val onSinglePermissionDenied: (() -> Unit)? = null,
    private val onMultiplePermissionGranted: (() -> Unit)? = null,
) {

    private var activity: AppCompatActivity? = null

    private var singlePermissionResult: ActivityResultLauncher<String>? = null

    private var multiplePermissionResult: ActivityResultLauncher<Array<String>>? = null

    fun initContracts(activity: AppCompatActivity) {
        if (this.activity == null) {
            this.activity = activity
        }

        if (singlePermissionResult == null) {
            singlePermissionResult =
                this.activity?.registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
                    if (isGranted) {
                        onSinglePermissionGranted?.invoke()
                    } else {
                        onSinglePermissionDenied?.invoke()
                    }
                }
        }

        if (multiplePermissionResult == null) {
            multiplePermissionResult =
                this.activity?.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { dataMap ->
                    val isNotificationsGranted =
                        dataMap[android.Manifest.permission.POST_NOTIFICATIONS] ?: false
                    if (isNotificationsGranted) {
                        onSinglePermissionGranted?.invoke()
                    }
                }
        }
    }

    fun requestSinglePermission(permission: String) {
        singlePermissionResult?.launch(permission)
    }

    fun requestMultiplePermissions(permission: List<String>) {
        multiplePermissionResult?.launch(permission.toTypedArray())
    }
}
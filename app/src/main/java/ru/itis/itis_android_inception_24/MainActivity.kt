package ru.itis.itis_android_inception_24

import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.core.content.ContextCompat
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.itis_android_inception_24.base.BaseActivity
import ru.itis.itis_android_inception_24.databinding.ActivityMainBinding
import ru.itis.itis_android_inception_24.screens.notificationsScreen.NotificationsFragment
import ru.itis.itis_android_inception_24.utils.AirplaneModeReceiver
import ru.itis.itis_android_inception_24.utils.NavigationAction
import ru.itis.itis_android_inception_24.utils.PermissionsHandler
import ru.itis.itis_android_inception_24.utils.ScreenTags

class MainActivity : BaseActivity() {

    private val viewBinding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    override val mainContainerId: Int = R.id.main_fragment_container

    private var airplaneReceiver: AirplaneModeReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (airplaneReceiver == null) {
            airplaneReceiver = AirplaneModeReceiver()
            val intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            this.registerReceiver(airplaneReceiver, intentFilter)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val permissionsHandler = PermissionsHandler(this)
            if (this.checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                permissionsHandler.requestSinglePermission(android.Manifest.permission.POST_NOTIFICATIONS)
            }
        }
        //if ()


        if (savedInstanceState == null) {
            navigate(
                destination = NotificationsFragment(),
                destinationTag = ScreenTags.NOTIFICATIONS_FRAGMENT_TAG,
                action = NavigationAction.ADD,
                isAddToBackStack = false,
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            101 -> {
                println("TEST TAG - GrantResult: $grantResults")
            }
        }
    }

    override fun onDestroy() {
        // this.unregisterReceiver(airplaneReceiver)
        super.onDestroy()
        airplaneReceiver = null
    }
}
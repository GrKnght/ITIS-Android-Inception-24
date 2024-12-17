package ru.itis.itis_android_inception_24

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.itis_android_inception_24.base.BaseActivity
import ru.itis.itis_android_inception_24.databinding.ActivityMainBinding
import ru.itis.itis_android_inception_24.screens.composeSample.ComposeSampleFragment
import ru.itis.itis_android_inception_24.screens.notificationsScreen.NotificationsFragment
import ru.itis.itis_android_inception_24.utils.AirplaneModeReceiver
import ru.itis.itis_android_inception_24.utils.NavigationAction
import ru.itis.itis_android_inception_24.utils.ScreenTags

class MainActivity : BaseActivity() {

    private val viewBinding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    override val mainContainerId: Int = R.id.main_fragment_container

    private var airplaneReceiver: AirplaneModeReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if (airplaneReceiver == null) {
//            airplaneReceiver = AirplaneModeReceiver()
//            val intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
//            this.registerReceiver(airplaneReceiver, intentFilter)
//        }
        if (savedInstanceState == null) {
            navigate(
                destination = NotificationsFragment(),
                destinationTag = ScreenTags.NOTIFICATIONS_FRAGMENT_TAG,
                action = NavigationAction.ADD,
                isAddToBackStack = false,
            )
        }
    }

    override fun onDestroy() {
       // this.unregisterReceiver(airplaneReceiver)
        super.onDestroy()
        airplaneReceiver = null
    }
}
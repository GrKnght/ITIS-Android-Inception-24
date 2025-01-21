package ru.itis.itis_android_inception_24

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.itis.itis_android_inception_24.base.BaseActivity
import ru.itis.itis_android_inception_24.databinding.ActivityMainBinding
import ru.itis.itis_android_inception_24.screens.profile.ProfileSampleFragment
import ru.itis.itis_android_inception_24.utils.NavigationAction
import ru.itis.itis_android_inception_24.utils.NotificationsHandler
import ru.itis.itis_android_inception_24.utils.ScreenTags

class MainActivity : BaseActivity() {

    private val viewBinding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    override val mainContainerId: Int = R.id.main_fragment_container

    var notificationsHandler: NotificationsHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val themeRes = when (intent.getIntExtra("theme_color", -1)) {
            1 -> {
                R.style.YellowColorTheme
            }

            2 -> {
                R.style.GreenColorTheme
            }

            3 -> {
                R.style.RedColorTheme
            }

            else -> R.style.Theme_ITIS_Android_Inception_24
        }
        setTheme(themeRes)
        setContentView(R.layout.activity_main)

        if (notificationsHandler == null) {
            notificationsHandler = NotificationsHandler(this.applicationContext)
        }
        if (intent.getIntExtra("notification_extra", -1) == 5) {
            Toast.makeText(this, "Запущено из уведомления", Toast.LENGTH_SHORT).show()
            intent.removeExtra("notification_extra")
        }


        if (savedInstanceState == null) {
            navigate(
                destination = ProfileSampleFragment(),
                destinationTag = ScreenTags.PROFILE_FRAGMENT_TAG,
                action = NavigationAction.ADD,
                isAddToBackStack = false,
            )
        }

    }
}
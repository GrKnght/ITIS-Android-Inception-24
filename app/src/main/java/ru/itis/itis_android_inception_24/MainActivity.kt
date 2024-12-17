package ru.itis.itis_android_inception_24

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.itis_android_inception_24.base.BaseActivity
import ru.itis.itis_android_inception_24.databinding.ActivityMainBinding
import ru.itis.itis_android_inception_24.screens.composeSample.ComposeSampleFragment

class MainActivity : BaseActivity() {

    private val viewBinding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    override val mainContainerId: Int = R.id.main_fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if (savedInstanceState == null) {
//            navigate(
//                destination = ComposeSampleFragment(),
//                destinationTag = ScreenTags.COMPOSE_SAMPLE_FRAGMENT_TAG,
//                action = NavigationAction.ADD,
//                isAddToBackStack = false,
//            )
//        }
        supportFragmentManager.beginTransaction()
            .replace(mainContainerId, ComposeSampleFragment())
            .commit()
    }
}
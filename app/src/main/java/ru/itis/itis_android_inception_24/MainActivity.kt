package ru.itis.itis_android_inception_24

import android.os.Bundle
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.itis_android_inception_24.base.BaseActivity
import ru.itis.itis_android_inception_24.databinding.ActivityMainBinding
import ru.itis.itis_android_inception_24.screens.init.InitFragment
import ru.itis.itis_android_inception_24.screens.mainpage.MainPageFragment
import ru.itis.itis_android_inception_24.utils.FragmentsLifecycleListener
import ru.itis.itis_android_inception_24.utils.NavigationAction

class MainActivity : BaseActivity() {

    private val viewBinding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    override val mainContainerId: Int = R.id.main_fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.registerFragmentLifecycleCallbacks(
            FragmentsLifecycleListener(),
            false
        )

        navigate(
            destination = InitFragment.getInstance(
                param1 = "firstStr",
                param2 = "secondStr",
                fragmentBg = R.color.purple_200
            ),
            destinationTag = InitFragment.TAG,
            action = NavigationAction.ADD
        )
    }

    fun doSomeLogic(tag: String) {
        supportFragmentManager.findFragmentByTag(tag)?.let { fragment ->
            supportFragmentManager.beginTransaction()
                .remove(fragment)
                .commit()
        } ?: Toast.makeText(this, "Fragment not found", Toast.LENGTH_SHORT).show()
    }
}
package ru.itis.itis_android_inception_24

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.itis_android_inception_24.databinding.ActivityMainBinding
import ru.itis.itis_android_inception_24.screens.init.InitFragment

class MainActivity : AppCompatActivity() {

    private val viewBinding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    private val mainContainerId: Int = R.id.main_fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(
                mainContainerId,
                InitFragment.getInstance(
                    param1 = "firstStr",
                    param2 = "secondStr",
                    fragmentBg = R.color.purple_200
                ), InitFragment.TAG
            )
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(
                mainContainerId,
                InitFragment.getInstance(
                    param1 = "secondStr",
                    param2 = "thirdStr",
                    fragmentBg = R.color.teal_200,
                ), "SecondInit"
            )
            .addToBackStack(null)
            .commit()

    }

    fun doSomeLogic(tag: String) {
        supportFragmentManager.findFragmentByTag(tag)?.let { fragment ->
            supportFragmentManager.beginTransaction()
                .remove(fragment)
                .commit()
        } ?: Toast.makeText(this, "Fragment not found", Toast.LENGTH_SHORT).show()
    }
}
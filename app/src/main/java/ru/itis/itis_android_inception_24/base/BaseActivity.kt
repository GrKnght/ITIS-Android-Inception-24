package ru.itis.itis_android_inception_24.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.itis.itis_android_inception_24.utils.NavigationAction

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val mainContainerId: Int

    fun navigate(
        destination: Fragment,
        destinationTag: String? = null,
        action: NavigationAction = NavigationAction.REPLACE,
        isAddToBackStack: Boolean = true,
        backStackTag: String? = null,
        isUseAnimation: Boolean = true,
    ) {
        val transaction = supportFragmentManager.beginTransaction()

        if (isUseAnimation) {
            transaction.setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.fade_out,
                android.R.anim.fade_in,
                android.R.anim.slide_out_right,
            )
        }

        when (action) {
            NavigationAction.ADD -> transaction.add(mainContainerId, destination, destinationTag)

            NavigationAction.REPLACE -> transaction.replace(
                mainContainerId,
                destination,
                destinationTag
            )

            NavigationAction.REMOVE -> transaction.remove(destination)
        }

        if (isAddToBackStack) {
            transaction.addToBackStack(backStackTag)
        }

        transaction.commit()
    }
}
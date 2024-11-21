package ru.itis.itis_android_inception_24.utils

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.util.TypedValue

fun getValueInDp(value: Float, ctx: Context): Float {
    val metrics = ctx.resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, metrics)
}

inline fun <reified T: Parcelable> Bundle.getParcelableSafe(key: String) : T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getParcelable(key, T::class.java)
    } else {
        this.getParcelable(key)
    }
}

inline fun <reified T: Parcelable> Bundle.getParcelableArraySafe(key: String): ArrayList<T>? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getParcelableArrayList(key, T::class.java)
    } else {
        this.getParcelableArrayList(key)
    }
}
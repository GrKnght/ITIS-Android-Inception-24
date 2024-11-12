package ru.itis.itis_android_inception_24.utils

import android.content.Context
import android.util.TypedValue

fun getValueInDp(value: Float, ctx: Context): Float {
    val metrics = ctx.resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, metrics)
}
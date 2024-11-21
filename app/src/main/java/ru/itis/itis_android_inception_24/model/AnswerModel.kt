package ru.itis.itis_android_inception_24.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnswerModel(
    val answerId: String,
    val answerText: String,
): Parcelable

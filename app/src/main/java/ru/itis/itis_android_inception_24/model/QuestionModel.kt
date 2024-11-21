package ru.itis.itis_android_inception_24.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuestionModel(
    val questionId: String,
    val questionText: String,
    val answers: List<AnswerModel>,
    var answerId: String? = null,
) : Parcelable {
    override fun toString(): String {
        val answersString = StringBuilder()
        answers.forEach { answer ->
            answersString.append("(Id: ${answer.answerId} Text: ${answer.answerText})")
        }
        return "QuestionId: $questionId Text: $questionText \nAnswers: $answersString\n"
    }
}
package ru.itis.itis_android_inception_24.model

sealed class MultipleHoldersData(
    open val id: String,
    open val headerText: String,
)

class FirstHolderData(
    override val id: String,
    override val headerText: String,
    val imageUrl: String,
) : MultipleHoldersData(id, headerText)

class SecondHolderData(
    override val id: String,
    override val headerText: String,
    val descText: String,
    val imageUrl: String,
) : MultipleHoldersData(id, headerText)
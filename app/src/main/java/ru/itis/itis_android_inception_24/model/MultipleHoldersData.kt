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

class ButtonHolderData(id: String, headerText: String) : MultipleHoldersData(id, headerText)

class TwoButtonHolderData(id: String, headerText: String) : MultipleHoldersData(id, headerText)

class SimpleTextHolderData(
    val text: String,
    id: String,
    headerText: String,
) : MultipleHoldersData(id, headerText)


package ru.itis.itis_android_inception_24.model

data class ItemWithPictureModel(
    val id: String,
    val imageUrl: String,
    val description: String,
    var isFavorite: Boolean = false,
)

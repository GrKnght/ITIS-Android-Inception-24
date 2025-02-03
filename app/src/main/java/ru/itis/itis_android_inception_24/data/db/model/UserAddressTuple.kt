package ru.itis.itis_android_inception_24.data.db.model

import androidx.room.ColumnInfo

data class UserAddressTuple(
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "address")
    val address: String,
)
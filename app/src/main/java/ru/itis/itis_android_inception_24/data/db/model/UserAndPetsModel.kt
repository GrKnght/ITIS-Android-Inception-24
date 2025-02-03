package ru.itis.itis_android_inception_24.data.db.model

import androidx.room.Embedded
import androidx.room.Relation
import ru.itis.itis_android_inception_24.data.db.entities.PetEntity
import ru.itis.itis_android_inception_24.data.db.entities.UserEntity

data class UserAndPetsModel(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "user_Id",
    )
    val pet: PetEntity,
)

package ru.itis.itis_android_inception_24.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.itis.itis_android_inception_24.data.db.entities.PetEntity
import ru.itis.itis_android_inception_24.data.db.model.UserAndPetsModel

@Dao
interface UserAndPetDao {

    @Query("SELECT * FROM users")
    fun getUsersAndPets(): List<UserAndPetsModel>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePet(pet: PetEntity)
}
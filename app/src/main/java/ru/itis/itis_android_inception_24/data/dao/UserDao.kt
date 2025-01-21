package ru.itis.itis_android_inception_24.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.itis.itis_android_inception_24.data.entities.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUserData(user: UserEntity)

    @Query("SELECT * FROM users WHERE :id=id")
    suspend fun getUserById(id: String): UserEntity?
}
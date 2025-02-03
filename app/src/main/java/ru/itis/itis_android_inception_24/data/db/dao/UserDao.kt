package ru.itis.itis_android_inception_24.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.itis.itis_android_inception_24.data.db.entities.UserEntity
import ru.itis.itis_android_inception_24.data.db.model.UserAddressTuple

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUserData(user: UserEntity)

    @Query("SELECT * FROM users WHERE :id=id")
    suspend fun getUserById(id: String): UserEntity?

    @Update(entity = UserEntity::class)
    suspend fun updateUserAddress(userData: UserAddressTuple)

    @Query("UPDATE users SET address = :address WHERE id = :userId ")
    suspend fun updateUserDataQuery(userId: String, address: String)
}
package ru.itis.itis_android_inception_24.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.itis.itis_android_inception_24.data.dao.UserDao
import ru.itis.itis_android_inception_24.data.entities.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class InceptionDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}
package ru.itis.itis_android_inception_24.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.itis.itis_android_inception_24.data.db.converters.DateConverter
import ru.itis.itis_android_inception_24.data.db.dao.FilmDao
import ru.itis.itis_android_inception_24.data.db.dao.UserAndPetDao
import ru.itis.itis_android_inception_24.data.db.dao.UserDao
import ru.itis.itis_android_inception_24.data.db.entities.FilmEntity
import ru.itis.itis_android_inception_24.data.db.entities.PetEntity
import ru.itis.itis_android_inception_24.data.db.entities.UserEntity

@Database(
    entities = [UserEntity::class, FilmEntity::class, PetEntity::class],
    version = 4
)
@TypeConverters(DateConverter::class)
abstract class InceptionDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val filmDao: FilmDao
    abstract val userAndPetsDao: UserAndPetDao

    companion object {
        const val DB_LOG_KEY = "InceptionDB"
    }
}
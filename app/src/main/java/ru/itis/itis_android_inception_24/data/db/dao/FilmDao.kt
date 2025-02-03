package ru.itis.itis_android_inception_24.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.itis.itis_android_inception_24.data.db.entities.FilmEntity

@Dao
interface FilmDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFilmInDb(filmData: FilmEntity)

    @Query("SELECT * FROM films WHERE user_id = :userId")
    fun getUserFilms(userId: String): List<FilmEntity>?
}
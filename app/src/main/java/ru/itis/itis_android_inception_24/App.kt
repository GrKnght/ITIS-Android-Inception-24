package ru.itis.itis_android_inception_24

import android.app.Application
import androidx.room.Room
import ru.itis.itis_android_inception_24.data.InceptionDatabase

class App : Application() {

    private var db: InceptionDatabase? = null

    private val DATABASE_NAME = "InceptionDB"

    override fun onCreate() {
        super.onCreate()
        if (db == null) {
            db = Room.databaseBuilder(this, InceptionDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }

    fun getDatabase(): InceptionDatabase {
        return db ?: throw IllegalStateException("Database not initialized")
    }
}
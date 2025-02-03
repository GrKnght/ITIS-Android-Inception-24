package ru.itis.itis_android_inception_24.data.db.migrations

import android.util.Log
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import ru.itis.itis_android_inception_24.data.db.InceptionDatabase

class Migration_2_3 : Migration(2, 3) {

    override fun migrate(db: SupportSQLiteDatabase) {
        try {
            db.execSQL("ALTER TABLE 'films' ADD COLUMN 'description' TEXT")
        } catch (ex: Exception) {
            Log.e(InceptionDatabase.DB_LOG_KEY, "Error while 2_3 migration: ${ex.message}")
        }
    }
}
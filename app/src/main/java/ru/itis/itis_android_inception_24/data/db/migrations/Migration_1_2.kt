package ru.itis.itis_android_inception_24.data.db.migrations

import android.util.Log
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import ru.itis.itis_android_inception_24.data.db.InceptionDatabase

class Migration_1_2 : Migration(1, 2) {

    override fun migrate(db: SupportSQLiteDatabase) {
        try {
            db.execSQL(
                "CREATE TABLE IF NOT EXISTS `films` " +
                        "(`id` TEXT NOT NULL, `user_id` TEXT NOT NULL, `film_name` TEXT NOT NULL, `release_date` TEXT NOT NULL, " +
                        "`rating` REAL NOT NULL, " +
                        "PRIMARY KEY(`id`), FOREIGN KEY(`user_id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )"
            )
        } catch (ex: Exception) {
            Log.e(InceptionDatabase.DB_LOG_KEY, "Error while 1_2 migration: ${ex.message}")
        }
    }

}
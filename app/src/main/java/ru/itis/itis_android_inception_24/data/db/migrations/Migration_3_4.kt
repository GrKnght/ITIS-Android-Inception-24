package ru.itis.itis_android_inception_24.data.db.migrations

import android.util.Log
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import ru.itis.itis_android_inception_24.data.db.InceptionDatabase

class Migration_3_4 : Migration(3, 4) {

    override fun migrate(db: SupportSQLiteDatabase) {
        try {
            db.execSQL(
                "CREATE TABLE IF NOT EXISTS `pets` (`id` TEXT NOT NULL, " +
                        "`name` TEXT NOT NULL, `user_Id` TEXT NOT NULL, PRIMARY KEY(`id`), " +
                        "FOREIGN KEY(`user_Id`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )"
            )
        } catch (ex: Exception) {
            Log.e(InceptionDatabase.DB_LOG_KEY, "Error while 2_3 migration: ${ex.message}")
        }
    }
}
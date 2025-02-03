package ru.itis.itis_android_inception_24.data.db.converters

import androidx.room.TypeConverter
import java.sql.Date

class DateConverter {

    @TypeConverter
    fun fromDateToLong(input: Date): Long {
        return 1L
    }

    @TypeConverter
    fun fromLongToDate(input: Long): Date {
        return Date(0L)
    }
}
package com.leesuchan.data.news.local

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun convertTimeToDate(timestamp: Long): Date {
        return Date(timestamp)
    }

    @TypeConverter
    fun convertDateToTime(date: Date): Long {
        return date.time
    }
}
package com.leesuchan.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.leesuchan.data.news.local.DateConverter
import com.leesuchan.data.news.model.ListingNewsEntity

@Database(entities = [ListingNewsEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class NewsPostmanDatabase : RoomDatabase() {

}
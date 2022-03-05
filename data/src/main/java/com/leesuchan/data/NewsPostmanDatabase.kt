package com.leesuchan.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.leesuchan.data.news.local.DateConverter
import com.leesuchan.data.news.local.NewsDao
import com.leesuchan.data.news.model.ListingNewsEntity

@Database(entities = [ListingNewsEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class NewsPostmanDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {
        @Volatile private var instance: NewsPostmanDatabase? = null

        fun getInstance(context: Context): NewsPostmanDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): NewsPostmanDatabase {
            return Room.databaseBuilder(
                context,
                NewsPostmanDatabase::class.java,
                "NewsPostmanDatabase"
            ).build()
        }
    }
}
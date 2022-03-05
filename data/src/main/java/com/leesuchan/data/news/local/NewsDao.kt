package com.leesuchan.data.news.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.leesuchan.data.news.model.ListingNewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsList(newsList: List<ListingNewsEntity>)

    @Query("SELECT * FROM ListingNewsEntity ORDER BY pub_date")
    fun getNewsList(): Flow<List<ListingNewsEntity>>
}
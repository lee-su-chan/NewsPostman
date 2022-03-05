package com.leesuchan.data.news

import com.leesuchan.data.news.model.ListingNewsEntity
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    val newsList: Flow<List<ListingNewsEntity>>

    suspend fun insertListingNews(news: List<ListingNewsEntity>)
}
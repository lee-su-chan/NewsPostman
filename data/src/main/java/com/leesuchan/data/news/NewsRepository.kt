package com.leesuchan.data.news

import com.leesuchan.data.news.model.ListingNewsEntity

interface NewsRepository {

    suspend fun insertListingNews(news: List<ListingNewsEntity>)
}
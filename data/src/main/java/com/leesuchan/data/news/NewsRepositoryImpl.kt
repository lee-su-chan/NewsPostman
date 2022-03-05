package com.leesuchan.data.news

import com.leesuchan.data.news.local.NewsDao
import com.leesuchan.data.news.model.ListingNewsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao
) : NewsRepository {

    override val newsList: Flow<List<ListingNewsEntity>>
        get() = newsDao.getNewsList()

    override suspend fun insertListingNews(news: List<ListingNewsEntity>) {
        newsDao.insertNewsList(news)
    }
}
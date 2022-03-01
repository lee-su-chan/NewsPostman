package com.leesuchan.data.news

import com.leesuchan.data.news.model.ListingNewsEntity
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor() : NewsRepository {

    override suspend fun insertListingNews(news: List<ListingNewsEntity>) {
        // TODO : 로컬 DB에 뉴스 목록 삽입 로직 추가
    }
}
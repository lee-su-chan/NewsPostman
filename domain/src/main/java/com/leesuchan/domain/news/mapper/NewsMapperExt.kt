package com.leesuchan.domain.news.mapper

import com.leesuchan.data.news.model.ListingNewsEntity
import com.leesuchan.domain.news.model.ListingNews

fun List<ListingNewsEntity>.toListingNewsList(): List<ListingNews> = map { it.toListingNews() }

fun ListingNewsEntity.toListingNews(): ListingNews = ListingNews(
    id = id,
    title = title,
    pubDate = pubDate,
    authorName = authorName,
    link = link
)
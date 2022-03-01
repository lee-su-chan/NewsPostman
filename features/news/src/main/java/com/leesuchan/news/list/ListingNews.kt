package com.leesuchan.news.list

import java.util.*

data class ListingNews(
    val id: String,
    val title: String,
    val pubDate: Date,
    val authorName: String,
    val link: String
)

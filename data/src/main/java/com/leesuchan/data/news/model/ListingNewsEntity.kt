package com.leesuchan.data.news.model

import java.util.*

data class ListingNewsEntity(
    val id: String,
    val title: String,
    val pubDate: Date,
    val authorName: String,
    val link: String
)

package com.leesuchan.data.news.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class ListingNewsEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "pub_date") val pubDate: Date,
    @ColumnInfo(name = "author_name") val authorName: String,
    @ColumnInfo(name = "link") val link: String
)

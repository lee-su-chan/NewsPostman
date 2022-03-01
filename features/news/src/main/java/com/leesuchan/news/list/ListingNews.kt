package com.leesuchan.news.list

import java.util.*

data class ListingNews(
    val id: String,
    val title: String,
    val pubDate: Date,
    val authorName: String,
    val link: String
) {
    companion object {
        val dummyList: List<ListingNews>
            get() = mutableListOf<ListingNews>().apply {
                repeat(30) {
                    add(dummy.copy(id = (it + 1).toString(), title = "${it + 1} ${dummy.title}"))
                }
            }

        private val dummy
            get() = ListingNews(
                id = "1",
                "지난해 가장 많이 본 뮤지컬과 콘서트는?",
                pubDate = Date(),
                authorName = "한겨레",
                link = "https://www.hani.co.kr/arti/culture/music/1031156.html"
            )
    }
}
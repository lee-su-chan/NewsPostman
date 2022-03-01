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
                "[공연소식] 뮤지컬 '지붕위의 바이올린' 4월 개막",
                pubDate = Date(),
                authorName = "매일경제",
                link = "https://www.mk.co.kr/news/culture/view/2022/02/176495/"
            )
    }
}
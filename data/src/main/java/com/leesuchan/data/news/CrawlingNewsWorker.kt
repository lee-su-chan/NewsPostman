package com.leesuchan.data.news

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.leesuchan.data.news.model.ListingNewsEntity
import com.prof.rssparser.Article
import com.prof.rssparser.Parser
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltWorker
class CrawlingNewsWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams) {

    companion object {
        private const val KEY_CRAWLING_URL = "key_crawling_url"

        fun createInputData(crawlingUrl: String): Data = workDataOf(KEY_CRAWLING_URL to crawlingUrl)
    }

    @Inject lateinit var parser: Parser
    @Inject lateinit var newsRepository: NewsRepository

    override suspend fun doWork(): Result {
        try {
            val crawlingUrl = inputData.getString(KEY_CRAWLING_URL) ?: return Result.failure()
            val channel = parser.getChannel(crawlingUrl)

            val newsList = channel.articles.toListingNewsEntityList()
            Timber.d("newsList: $newsList")

            newsRepository.insertListingNews(newsList)

            return Result.success()
        } catch (e: Exception) {
            Timber.e(e)
            return Result.failure()
        }
    }
}

fun List<Article>.toListingNewsEntityList(): List<ListingNewsEntity> =
    asSequence().map { it.toListingNewsEntity() }.filterNotNull().toList()

fun Article.toListingNewsEntity(): ListingNewsEntity? {
    val id = guid ?: return null
    val publishDateStr = pubDate ?: ""
    val publishDate = if (publishDateStr.isBlank()) Date() else {
        val sourceSdf = SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH)
        val result = sourceSdf.parse(publishDateStr)
        result
    }
    val authorName = sourceName ?: ""
    val newsTitle = title?.removeSuffix(" - $authorName") ?: ""

    return ListingNewsEntity(
        id = id,
        title = newsTitle,
        pubDate = publishDate,
        authorName = authorName,
        link = link ?: ""
    )
}
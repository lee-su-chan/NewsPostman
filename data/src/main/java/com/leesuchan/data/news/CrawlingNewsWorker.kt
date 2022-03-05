package com.leesuchan.data.news

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.prof.rssparser.Parser
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber
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

    override suspend fun doWork(): Result {
        val crawlingUrl = inputData.getString(KEY_CRAWLING_URL) ?: return Result.failure()
        val channel = parser.getChannel(crawlingUrl)

        // TODO : NewsRepository에서 뉴스 목록 삽입 함수 호출
        Timber.d("channel: $channel")

        return Result.success()
    }
}
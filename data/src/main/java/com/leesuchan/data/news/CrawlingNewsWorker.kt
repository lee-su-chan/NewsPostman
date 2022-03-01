package com.leesuchan.data.news

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.prof.rssparser.Parser
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CrawlingNewsWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {

    @Inject lateinit var parser: Parser

    override suspend fun doWork(): Result {
        val channel = parser.getChannel("")
        // TODO : NewsRepository에서 뉴스 목록 삽입 함수 호출
        return Result.success()
    }
}
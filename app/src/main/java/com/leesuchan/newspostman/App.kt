package com.leesuchan.newspostman

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.leesuchan.data.news.CrawlingNewsWorker
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltAndroidApp
class App : Application(), Configuration.Provider {

    companion object {
        const val CRAWLING_URL =
            "https://news.google.com/rss/topics/CAAqJggKIiBDQkFTRWdvSUwyMHZNRFZxYUdjU0FtdHZHZ0pMVWlnQVAB?hl=ko&gl=KR&ceid=KR%3Ako"
        const val CRAWLING_REPEAT_INTERVAL_MINUTES = 15L
        const val CRAWLING_WORKER_UNIQUE_NAME = "crawlingNewsWorker"
    }

    @Inject lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        requestCrawlingNewsWorker()
    }

    private fun requestCrawlingNewsWorker() {
        val workerRequest = PeriodicWorkRequestBuilder<CrawlingNewsWorker>(
            CRAWLING_REPEAT_INTERVAL_MINUTES,
            TimeUnit.MINUTES
        ).setInputData(CrawlingNewsWorker.createInputData(CRAWLING_URL)).build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            CRAWLING_WORKER_UNIQUE_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            workerRequest
        )
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder().setWorkerFactory(workerFactory).build()
    }
}
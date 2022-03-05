package com.leesuchan.data.di

import android.content.Context
import com.leesuchan.data.NewsPostmanDatabase
import com.leesuchan.data.news.local.NewsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideNewsPostmanDatabase(@ApplicationContext context: Context): NewsPostmanDatabase {
        return NewsPostmanDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideNewsDao(newsPostmanDatabase: NewsPostmanDatabase): NewsDao {
        return newsPostmanDatabase.newsDao()
    }
}
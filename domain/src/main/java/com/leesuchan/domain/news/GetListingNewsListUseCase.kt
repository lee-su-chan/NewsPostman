package com.leesuchan.domain.news

import com.leesuchan.data.news.NewsRepository
import com.leesuchan.domain.FlowUseCase
import com.leesuchan.domain.news.mapper.toListingNewsList
import com.leesuchan.domain.news.model.ListingNews
import com.leesuchan.shared.di.IoDispatcher
import com.leesuchan.shared.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetListingNewsListUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val newsRepository: NewsRepository
) : FlowUseCase<Unit, List<ListingNews>>(dispatcher) {

    override fun execute(parameters: Unit): Flow<Result<List<ListingNews>>> {
        return newsRepository.newsList.map { Result.Success(it.toListingNewsList()) }
    }
}
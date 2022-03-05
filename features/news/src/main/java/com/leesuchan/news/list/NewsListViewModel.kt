package com.leesuchan.news.list

import androidx.lifecycle.viewModelScope
import com.leesuchan.coreui.ui.BaseViewModel
import com.leesuchan.domain.news.GetListingNewsListUseCase
import com.leesuchan.domain.news.model.ListingNews
import com.leesuchan.shared.model.getOrDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    getListingNewsListUseCase: GetListingNewsListUseCase
) : BaseViewModel() {

    val listingNews: SharedFlow<List<ListingNews>> = getListingNewsListUseCase(Unit)
        .map { it.getOrDefault(emptyList()) }
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
}
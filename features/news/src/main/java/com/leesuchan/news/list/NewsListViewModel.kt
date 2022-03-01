package com.leesuchan.news.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.leesuchan.coreui.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor() : BaseViewModel() {

    private val _listingNews = MutableLiveData<List<ListingNews>>()
    val listingNews: LiveData<List<ListingNews>> get() = _listingNews

    init {
        // TODO : 추후 Usecase를 사용하도록 변경
        _listingNews.value = ListingNews.dummyList
    }
}
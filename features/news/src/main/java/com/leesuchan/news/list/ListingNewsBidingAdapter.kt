package com.leesuchan.news.list

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.leesuchan.coreui.util.format

object ListingNewsBidingAdapter {

    @JvmStatic
    @BindingAdapter("listingNews")
    fun TextView.setListingNewsSubTitle(listingNews: ListingNews?) {
        text = listingNews?.let {
            "${it.authorName} - ${it.pubDate.format("yyyy-MM-dd HH:mm")}"
        } ?: ""
    }
}
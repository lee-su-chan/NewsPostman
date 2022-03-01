package com.leesuchan.news.list

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leesuchan.coreui.util.format

object ListingNewsBidingAdapter {

    @JvmStatic
    @BindingAdapter("listingNews")
    fun RecyclerView.setListingNews(list: List<ListingNews>?) {
        list?.let { (adapter as? ListingNewsAdapter)?.submitList(it) }
    }

    @JvmStatic
    @BindingAdapter("listingNews")
    fun TextView.setListingNewsSubTitle(listingNews: ListingNews?) {
        text = listingNews?.let {
            "${it.authorName} - ${it.pubDate.format("yyyy-MM-dd HH:mm")}"
        } ?: ""
    }
}
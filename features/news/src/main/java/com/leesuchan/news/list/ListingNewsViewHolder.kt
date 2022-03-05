package com.leesuchan.news.list

import android.view.ViewGroup
import com.leesuchan.coreui.ui.BaseViewHolder
import com.leesuchan.domain.news.model.ListingNews
import com.leesuchan.news.R
import com.leesuchan.news.databinding.ItemListingNewsBinding

class ListingNewsViewHolder(
    parent: ViewGroup,
    private val onClicked: (ListingNews) -> Unit
) : BaseViewHolder<ItemListingNewsBinding, ListingNews>(
    parent,
    R.layout.item_listing_news
) {
    override fun bind(data: ListingNews) {
        binding.run {
            listingNews = data
            vRoot.setOnClickListener { onClicked(data) }
            executePendingBindings()
        }
    }
}
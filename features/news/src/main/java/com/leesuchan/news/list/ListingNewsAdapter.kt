package com.leesuchan.news.list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class ListingNewsAdapter(
    private val onClicked: (ListingNews) -> Unit
) : ListAdapter<ListingNews, ListingNewsViewHolder>(diff) {

    companion object {
        private val diff = object : DiffUtil.ItemCallback<ListingNews>() {
            override fun areItemsTheSame(oldItem: ListingNews, newItem: ListingNews): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ListingNews, newItem: ListingNews): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingNewsViewHolder =
        ListingNewsViewHolder(parent, onClicked)

    override fun onBindViewHolder(holder: ListingNewsViewHolder, position: Int) =
        holder.bind(getItem(position))
}
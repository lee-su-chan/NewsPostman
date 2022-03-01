package com.leesuchan.news.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.leesuchan.coreui.ui.BaseFragment
import com.leesuchan.news.R
import com.leesuchan.news.databinding.FragmentNewsListBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class NewsListFragment : BaseFragment<FragmentNewsListBinding>(R.layout.fragment_news_list) {

    override val viewModel: NewsListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            viewModel = this@NewsListFragment.viewModel
            executePendingBindings()
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvListingNews.adapter = ListingNewsAdapter {
            Timber.d("onClicked: $it")
            findNavController().navigate(
                NewsListFragmentDirections.actionNewListScreenToNewDetailScreen(it.link)
            )
        }
    }
}
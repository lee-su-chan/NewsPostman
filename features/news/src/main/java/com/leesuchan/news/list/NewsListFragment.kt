package com.leesuchan.news.list

import androidx.fragment.app.viewModels
import com.leesuchan.coreui.ui.BaseFragment
import com.leesuchan.coreui.ui.EmptyViewModel
import com.leesuchan.news.R
import com.leesuchan.news.databinding.FragmentNewsListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : BaseFragment<FragmentNewsListBinding>(R.layout.fragment_news_list) {

    override val viewModel: EmptyViewModel by viewModels()
}
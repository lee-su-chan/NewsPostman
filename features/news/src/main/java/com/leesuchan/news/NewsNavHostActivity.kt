package com.leesuchan.news

import androidx.activity.viewModels
import com.leesuchan.coreui.ui.BaseActivity
import com.leesuchan.coreui.ui.EmptyViewModel
import com.leesuchan.news.databinding.ActivityNewsNavHostBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsNavHostActivity :
    BaseActivity<ActivityNewsNavHostBinding>(R.layout.activity_news_nav_host) {

    override val viewModel: EmptyViewModel by viewModels()
}
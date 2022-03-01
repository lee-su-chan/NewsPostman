package com.leesuchan.news.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.leesuchan.coreui.ui.BaseFragment
import com.leesuchan.coreui.ui.EmptyViewModel
import com.leesuchan.news.R
import com.leesuchan.news.databinding.FragmentNewsDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>(R.layout.fragment_news_detail) {

    override val viewModel: EmptyViewModel by viewModels()
    private val args: NewsDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        binding.webView.run {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
            Timber.d("args.newsLink: ${args.newsLink}")
            loadUrl(args.newsLink)
        }
    }
}
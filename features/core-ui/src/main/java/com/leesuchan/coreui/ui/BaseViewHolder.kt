package com.leesuchan.coreui.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T : ViewDataBinding, D>(
    parent: ViewGroup,
    @LayoutRes layoutId: Int,
    protected val binding: T = DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        layoutId,
        parent,
        false
    )
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(data: D)
}
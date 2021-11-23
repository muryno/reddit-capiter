
package com.muryno.reddits.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.muryno.reddits.R
import com.muryno.reddits.databinding.AdapterRowBinding
import com.muryno.reddits.databinding.ItemLoadingStateBinding

class RedditLoadingAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<RedditLoadingAdapter.LoadingStateViewHolder>() {

    class LoadingStateViewHolder(itemView: ItemLoadingStateBinding, retry: () -> Unit) :
        RecyclerView.ViewHolder(itemView.root) {

        private val tvErrorMessage: TextView = itemView.tvErrorMessage
        private val progressBar: ProgressBar = itemView.progressBar
        private val btnRetry: Button = itemView.btnRetry

        init {
            btnRetry.setOnClickListener {
                retry.invoke()
            }
        }


        fun bindState(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                tvErrorMessage.text = loadState.error.localizedMessage
            }
            progressBar.isVisible = loadState is LoadState.Loading
            tvErrorMessage.isVisible = loadState !is LoadState.Loading
            btnRetry.isVisible = loadState !is LoadState.Loading

        }

    }

    override fun onBindViewHolder(holder: LoadingStateViewHolder, loadState: LoadState) {
        holder.bindState(loadState)
    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): LoadingStateViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding: ItemLoadingStateBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_loading_state,
            parent,
            false
        )
        return LoadingStateViewHolder(binding, retry)
    }
}
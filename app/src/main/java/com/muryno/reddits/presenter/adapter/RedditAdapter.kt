package com.muryno.reddits.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muryno.domain.entiity.RedditPostEntity
import com.muryno.reddits.R
import com.muryno.reddits.databinding.AdapterRowBinding


class RedditAdapter(private val onItemClicked: (RedditPostEntity) -> Unit) :
    PagingDataAdapter<RedditPostEntity, RedditAdapter.RedditViewHolder>(COMPARATOR) {
    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<RedditPostEntity>() {
            override fun areItemsTheSame(
                oldItemCarbon: RedditPostEntity,
                newItemCarbon: RedditPostEntity
            ): Boolean {
                return oldItemCarbon.id == newItemCarbon.id
            }
            override fun areContentsTheSame(
                oldItemCarbon: RedditPostEntity,
                newItemCarbon: RedditPostEntity
            ): Boolean {
                return oldItemCarbon == newItemCarbon
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: AdapterRowBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.adapter_row,
            parent,
            false
        )

        return RedditViewHolder(view)
    }

    override fun onBindViewHolder(holder: RedditViewHolder, position: Int) {
        holder.itemView.setOnClickListener { getItem(position)?.let { it1 -> onItemClicked(it1) } }
        getItem(position)?.let { holder.bindPost(it) }
    }
    inner class RedditViewHolder(val binding: AdapterRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindPost(redditPost: RedditPostEntity) {
            binding.apply {
                score.text = redditPost.score.toString()
                comments.text = redditPost.num_comments.toString()
                title.text = redditPost.title
                if (redditPost.is_video == true) {
                    playIcon.visibility = View.VISIBLE
                } else {
                    playIcon.visibility = View.GONE
                }

                Glide.with(binding.imageViewDetails.context)
                    .load(redditPost.thumbnail)
                    .placeholder(R.drawable.ic_baseline_image_24)
                    .into(binding.imageViewDetails)

            }
        }
    }
}
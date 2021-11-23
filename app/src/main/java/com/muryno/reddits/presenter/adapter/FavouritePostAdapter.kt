package com.muryno.reddits.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muryno.domain.entiity.RedditPostEntity
import com.muryno.reddits.R
import com.muryno.reddits.databinding.AdapterRowBinding
import com.muryno.reddits.presenter.utils.SwipeGesture
import javax.inject.Inject


class FavouritePostAdapter @Inject constructor() :
    RecyclerView.Adapter<FavouritePostAdapter.MyViewHolder>() {


    private val callback = object : DiffUtil.ItemCallback<RedditPostEntity>() {
        override fun areItemsTheSame(
            oldItemNews: RedditPostEntity,
            newItemNews: RedditPostEntity
        ): Boolean {
            return oldItemNews.id == newItemNews.id
        }

        override fun areContentsTheSame(
            oldItemNews: RedditPostEntity,
            newItemNews: RedditPostEntity
        ): Boolean {
            return oldItemNews == newItemNews
        }

    }

    val differ = AsyncListDiffer(this, callback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: AdapterRowBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.adapter_row,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val worldNewsItem= differ.currentList[position]
        holder.bind(worldNewsItem)
    }


    inner class MyViewHolder(val binding: AdapterRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(redditPost: RedditPostEntity) {
            binding.apply {
                score.text = redditPost.score.toString()
                comments.text = redditPost.num_comments.toString()
                title.text = redditPost.title
                if(redditPost.is_video!= null) {
                    playIcon.visibility = View.VISIBLE
                }else{
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
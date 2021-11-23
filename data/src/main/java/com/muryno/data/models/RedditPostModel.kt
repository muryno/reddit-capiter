package com.muryno.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.muryno.domain.entiity.RedditPostEntity

@Entity(tableName = "reddit_Posts")
data class RedditPostModel(
    @PrimaryKey()
    val id: String ,
    val key: String? = null,
    val title: String? = null,
    var isFavourite: String? = null,
    val score: Int? = null,
    val author: String? = null,
    val num_comments: Int? = null,
    val author_fullname: String? = null,
    val name: String? = null,
    val total_awards_received: Int? = null,
    val thumbnail: String? = null,
    val post_hint: String? = null,
    val url_overridden_by_dest: String? = null,
    val is_video: Boolean? = null,
    val url: String? = null,
    val parent_whitelist_status: String? = null,
    val author_is_blocked: Boolean? = null,
    val subreddit_type: String? = null,
)

fun RedditPostModel.mapToDomain() : RedditPostEntity
        = RedditPostEntity(
    id = id,
    key =key,
    title= title,
    score = score,
    author = author,
    num_comments = num_comments,
    author_fullname = author_fullname,
    name = name,
    total_awards_received = total_awards_received,
    thumbnail =  thumbnail,
    post_hint= post_hint,
    url_overridden_by_dest = url_overridden_by_dest,
    is_video =  is_video,
    url =  url,
    parent_whitelist_status =parent_whitelist_status,
    author_is_blocked=author_is_blocked,
    isFavourite = isFavourite,
    subreddit_type =  subreddit_type , )

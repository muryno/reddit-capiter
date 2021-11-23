package com.muryno.domain.entiity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RedditPostEntity(
    val id: String,
    val key: String? = null,
    val title: String? = null,
    val score: Int? = null,
    var isFavourite: String? = null,
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
) : Parcelable

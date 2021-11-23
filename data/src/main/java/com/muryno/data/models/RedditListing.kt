package com.muryno.data.models

class RedditListing(
    val children: List<PostContainer>,
    val after: String?,
    val dist: Int,
    val before: String?
)
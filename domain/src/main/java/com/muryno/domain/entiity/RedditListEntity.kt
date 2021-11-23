package com.muryno.domain.entiity


data class RedditListEntity(
    val children: List<RedditPostEntity>,
    val after: String?,
    val dist: Int,
    val before: String?
)


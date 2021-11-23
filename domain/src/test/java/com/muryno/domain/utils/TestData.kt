package com.muryno.domain.utils


import com.muryno.domain.entiity.RedditPostEntity


internal fun getRedditPostEntityList():List<RedditPostEntity>
        = listOf(
    RedditPostEntity(
        id = "1234",
        key = "",
        title= "title",
        score =3,
        author = "author",
        num_comments = 3,
        author_fullname = "author_fullname",
        name = "testing",
        total_awards_received = 3,
        thumbnail =  "",
        post_hint= "",
        url_overridden_by_dest = "",
        is_video = true,
        url =  "url",
        parent_whitelist_status ="parent_whitelist_status",
        subreddit_type =  "" ,
    ),

    RedditPostEntity(
        id = "1234",
        key = "",
        title= "title",
        score =3,
        author = "author",
        num_comments = 3,
        author_fullname = "author_fullname",
        name = "testing",
        total_awards_received = 3,
        thumbnail =  "",
        post_hint= "",
        url_overridden_by_dest = "",
        is_video = true,
        url =  "url",
        parent_whitelist_status ="parent_whitelist_status",
        subreddit_type =  "" ,
    ),
)


internal fun getRedditPostEntity(): RedditPostEntity
        =
    RedditPostEntity(
        id = "1234",
        key = "",
        title= "title",
        score =3,
        author = "author",
        num_comments = 3,
        author_fullname = "author_fullname",
        name = "testing",
        total_awards_received = 3,
        thumbnail =  "",
        post_hint= "",
        url_overridden_by_dest = "",
        is_video = true,
        url =  "url",
        parent_whitelist_status ="parent_whitelist_status",
        subreddit_type =  "" ,

        )
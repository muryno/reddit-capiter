package com.muryno.data.utils

import com.muryno.data.models.PostContainer
import com.muryno.data.models.RedditApiResponse
import com.muryno.data.models.RedditListing
import com.muryno.data.models.RedditPostModel
import com.muryno.domain.entiity.RedditPostEntity

object TestData {

    internal fun getRedditPostModel():RedditPostModel
            = RedditPostModel(
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

    internal fun getRedditPostModelList():List<RedditPostModel>
            = listOf(
        RedditPostModel(
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

        RedditPostModel(
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


    internal fun getRedditPostEntity():RedditPostEntity
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


    internal fun getPostContainer(): PostContainer
    = PostContainer(data = getRedditPostModel())

    internal fun getRedditCollection()
    = RedditListing(
        children = listOf(getPostContainer()),
        dist = 1,
        after = "poo",
        before = ""
    )

    internal fun getRedditApiResponse()
            = RedditApiResponse(
        data = getRedditCollection(),
    )



}

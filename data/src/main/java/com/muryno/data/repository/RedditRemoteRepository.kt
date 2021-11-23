package com.muryno.data.repository

import com.muryno.data.models.RedditApiResponse
import com.muryno.data.remote.RedditRemoteDataSource
import io.reactivex.Single

class RedditRemoteRepository(val redditRemoteDataSource: RedditRemoteDataSource) {
    fun getRedditApi(
        page: Int ,
        after: String ,
        t: String,
        before: String
    ): Single<RedditApiResponse> = redditRemoteDataSource.getRedditApi(page=page,after=after,t=t,before=before)
}
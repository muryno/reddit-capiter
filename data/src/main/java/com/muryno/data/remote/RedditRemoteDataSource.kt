package com.muryno.data.remote



import com.muryno.data.remote.api.RedditService
import com.muryno.data.models.RedditApiResponse
import io.reactivex.Single

class RedditRemoteDataSource ( private val redditService: RedditService) {
     fun getRedditApi(
        page: Int,
        after: String,
        t: String,
        before: String
    ): Single<RedditApiResponse> = redditService.getRedditApi(page= page, after = after,t=t)

}
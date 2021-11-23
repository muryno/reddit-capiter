package com.muryno.data.remote



import com.muryno.data.models.RedditApiResponse
import com.muryno.data.remote.api.RedditService
import io.reactivex.Single

class RedditRemoteDataSource ( private val redditService: RedditService) {
     fun getRedditApi(
        page: Int,
        after: String,
        t: String,
        before: String
    ): Single<RedditApiResponse> = redditService.getRedditApi(page= page, after = after,t=t)


    fun getSearchedRedditFromApi(
        page: Int,
        after: String,
        t: String,
        query: String
    ): Single<RedditApiResponse> = redditService.getSearchedRedditFromApi(page= page, after = after,t=t,query = query)
}
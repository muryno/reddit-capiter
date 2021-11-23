package com.muryno.domain.gateway

import androidx.paging.PagingData
import com.muryno.domain.entiity.RedditPostEntity
import io.reactivex.Flowable
import io.reactivex.Single

interface GetRedditDbRepository {
    fun saveFavouritePosts(redditModel: RedditPostEntity)
    fun fetchAllFavouritePost(): Single<List<RedditPostEntity>>
    fun clearReddit()
    fun clearSingleReddit(id: Int)
}
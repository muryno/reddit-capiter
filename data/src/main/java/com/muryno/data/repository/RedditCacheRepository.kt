package com.muryno.data.repository

import com.muryno.data.remote.RedditCacheDataSource
import com.muryno.domain.entiity.RedditPostEntity
import io.reactivex.Single

class RedditCacheRepository(private val redditCacheDataSource: RedditCacheDataSource) {

    fun saveFavouritePosts(redditModel: RedditPostEntity) =
        redditCacheDataSource.saveFavouritePosts(redditModel = redditModel)

    fun fetchAllFavouritePost(): Single<List<RedditPostEntity>> =
        redditCacheDataSource.fetchAllFavouritePost()

    fun clearReddit() = redditCacheDataSource.clearReddit()

    fun clearSingleReddit(id: String) = redditCacheDataSource.clearSingleReddit(id)
}
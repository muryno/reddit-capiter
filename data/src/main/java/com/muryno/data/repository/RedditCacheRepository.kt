package com.muryno.data.repository

import androidx.paging.PagingSource
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.muryno.data.models.RedditKeys
import com.muryno.data.models.RedditPostModel
import com.muryno.data.remote.RedditCacheDataSource
import com.muryno.domain.entiity.RedditPostEntity
import io.reactivex.Single

class RedditCacheRepository(private val redditCacheDataSource : RedditCacheDataSource) {

    fun saveFavouritePosts(redditModel: RedditPostEntity) = redditCacheDataSource.saveFavouritePosts(redditModel=redditModel)

    fun fetchAllFavouritePost(): Single<List<RedditPostEntity>> = redditCacheDataSource.fetchAllFavouritePost()

    fun clearReddit() = redditCacheDataSource.clearReddit()

    fun clearSingleReddit(id: Int) = redditCacheDataSource.clearSingleReddit(id)
}
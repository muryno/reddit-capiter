package com.muryno.data.gateway

import com.muryno.data.repository.RedditCacheRepository
import com.muryno.domain.entiity.RedditPostEntity
import com.muryno.domain.gateway.GetRedditDbRepository
import io.reactivex.Single
import javax.inject.Inject

class GetRedditDataBaseImpl @Inject constructor(private val redditCacheRepository: RedditCacheRepository):
    GetRedditDbRepository {
    override fun saveFavouritePosts(redditModel: RedditPostEntity)= redditCacheRepository.saveFavouritePosts(redditModel)

    override fun fetchAllFavouritePost(): Single<List<RedditPostEntity>> = redditCacheRepository.fetchAllFavouritePost()

    override fun clearReddit()= redditCacheRepository.clearReddit()

    override fun clearSingleReddit(id: String) = redditCacheRepository.clearSingleReddit(id)

}
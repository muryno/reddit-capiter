package com.muryno.data.remote


import com.muryno.data.remote.db.dao.RedditDao
import com.muryno.data.mapper.RedditModelToDomainMapper
import com.muryno.data.models.RedditPostModel
import com.muryno.domain.entiity.RedditPostEntity
import io.reactivex.Single

class RedditCacheDataSource (private val redditDao: RedditDao) {

    fun saveFavouritePosts(redditModel: RedditPostEntity) =
        redditDao.saveFavouritePosts(redditModel=transformRedditPostModelToRedditPostEntity(redditModel))

    fun fetchAllFavouritePost(): Single<List<RedditPostEntity>> {
        return  transformListRedditPostModelToRedditPostEntity( redditDao.selectReddit())
    }


    fun clearReddit() = redditDao.clearReddit()

    fun clearSingleReddit(id: String) = redditDao.clearSingleReddit(id)


    fun transformListRedditPostModelToRedditPostEntity(redditPostModel:  Single<List<RedditPostModel>>): Single<List<RedditPostEntity>>
            =  redditPostModel.map { it.map {tt-> RedditModelToDomainMapper.transformTo(tt) } }


    fun  transformRedditPostModelToRedditPostEntity(redditPostModel:RedditPostEntity  ): RedditPostModel{
        return    RedditModelToDomainMapper.transformFrom(redditPostModel)
    }


}


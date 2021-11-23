package com.muryno.reddits.presenter.di.module


import com.muryno.data.gateway.GetRedditDataBaseImpl
import com.muryno.data.gateway.GetRedditRxGatewayImpl
import com.muryno.data.paging.GetRedditRxPagingSource
import com.muryno.data.remote.RedditCacheDataSource
import com.muryno.data.remote.RedditRemoteDataSource
import com.muryno.data.remote.api.RedditService
import com.muryno.data.remote.db.dao.RedditDao
import com.muryno.data.repository.RedditCacheRepository
import com.muryno.data.repository.RedditRemoteRepository
import com.muryno.domain.gateway.GetRedditDbRepository
import com.muryno.domain.gateway.GetRedditRepository
import dagger.Module
import dagger.Provides


@Module
class DataModule {

    @Provides
    fun provideRedditListRemoteDataSource(redditService: RedditService)
            = RedditRemoteDataSource(redditService)

    @Provides
    fun provideRedditLocalStorageDataSource(redditDao: RedditDao)
            = RedditCacheDataSource(redditDao)

    @Provides
    fun provideRedditRemoteDataSource(redditRemoteDataSource: RedditRemoteDataSource)
            = RedditRemoteRepository(redditRemoteDataSource)


    @Provides
    fun provideRedditCacheRepository(redditCacheDataSource: RedditCacheDataSource)
            = RedditCacheRepository(redditCacheDataSource)


    @Provides
    fun provideMovieGateWay(redditCacheRepository: RedditCacheRepository): GetRedditDbRepository
            = GetRedditDataBaseImpl(redditCacheRepository)

    @Provides
    fun provideMovieDetailGteWay(getRedditRxPagingSource: GetRedditRxPagingSource): GetRedditRepository
            = GetRedditRxGatewayImpl(getRedditRxPagingSource)

}
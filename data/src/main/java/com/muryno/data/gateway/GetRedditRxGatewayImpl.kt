package com.muryno.data.gateway

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.flowable
import com.muryno.data.paging.GetRedditRxPagingSource
import com.muryno.domain.entiity.RedditPostEntity
import com.muryno.domain.gateway.GetRedditRepository
import io.reactivex.Flowable

class GetRedditRxGatewayImpl (private val redditRemoteRepository: GetRedditRxPagingSource):
    GetRedditRepository {
    override fun getRedditPost():  Flowable<PagingData<RedditPostEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                maxSize = 400,
                prefetchDistance = 5,
                initialLoadSize = 20),
            pagingSourceFactory = { redditRemoteRepository }
        ).flowable
    }


}
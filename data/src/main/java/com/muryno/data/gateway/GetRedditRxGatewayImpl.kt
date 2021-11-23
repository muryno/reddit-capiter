package com.muryno.data.gateway

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.flowable
import com.muryno.data.paging.GetRedditRxPagingSource
import com.muryno.data.repository.RedditRemoteRepository
import com.muryno.domain.entiity.RedditPostEntity
import com.muryno.domain.gateway.GetRedditRepository
import io.reactivex.Flowable

class GetRedditRxGatewayImpl(
    private val service: RedditRemoteRepository,
) :
    GetRedditRepository {

    override fun getRedditPost(query: String?): Flowable<PagingData<RedditPostEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                maxSize = 400,
                prefetchDistance = 5,
                initialLoadSize = 20
            ),
            pagingSourceFactory = { GetRedditRxPagingSource(service, query) }
        ).flowable
    }


}
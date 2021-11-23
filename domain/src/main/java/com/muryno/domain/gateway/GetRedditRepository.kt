package com.muryno.domain.gateway

import androidx.paging.PagingData
import com.muryno.domain.entiity.RedditPostEntity
import io.reactivex.Flowable

interface GetRedditRepository {
    fun getRedditPost( query : String?): Flowable<PagingData<RedditPostEntity>>
}
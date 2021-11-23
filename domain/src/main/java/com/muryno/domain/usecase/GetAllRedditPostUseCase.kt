package com.muryno.domain.usecase

import androidx.paging.PagingData
import com.muryno.domain.entiity.RedditPostEntity
import com.muryno.domain.gateway.GetRedditRepository
import io.reactivex.Flowable

class GetAllRedditPostUseCase  (private val getRedditRepository: GetRedditRepository) {

    fun call(query:String?): Flowable<PagingData<RedditPostEntity>> = getRedditRepository.getRedditPost(query)

}
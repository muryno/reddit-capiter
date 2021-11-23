package com.muryno.domain.usecase

import androidx.paging.PagingData
import com.muryno.domain.entiity.RedditPostEntity
import com.muryno.domain.gateway.GetRedditRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetAllRedditPostUseCase  (private val getRedditRepository: GetRedditRepository) {

    fun call(): Flowable<PagingData<RedditPostEntity>> = getRedditRepository.getRedditPost()
}
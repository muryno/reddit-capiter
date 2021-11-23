package com.muryno.domain.usecase

import androidx.paging.PagingData
import com.muryno.domain.entiity.RedditPostEntity
import com.muryno.domain.gateway.GetRedditDbRepository
import com.muryno.domain.gateway.GetRedditRepository
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class SaveFavouritePostUseCase  (private val getRedditRepository: GetRedditDbRepository) {
    fun call(post: RedditPostEntity) = getRedditRepository.saveFavouritePosts(post)
}
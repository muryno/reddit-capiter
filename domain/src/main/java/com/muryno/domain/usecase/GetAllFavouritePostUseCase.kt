package com.muryno.domain.usecase

import com.muryno.domain.entiity.RedditPostEntity
import com.muryno.domain.gateway.GetRedditDbRepository
import io.reactivex.Single

class GetAllFavouritePostUseCase  (private val getRedditRepository: GetRedditDbRepository) {
    fun call(): Single<List<RedditPostEntity>> = getRedditRepository.fetchAllFavouritePost()
}
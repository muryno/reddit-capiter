package com.muryno.domain.usecase

import com.muryno.domain.entiity.RedditPostEntity
import com.muryno.domain.gateway.GetRedditDbRepository

class SaveFavouritePostUseCase(private val getRedditRepository: GetRedditDbRepository) {
    fun call(post: RedditPostEntity) = getRedditRepository.saveFavouritePosts(post)
}
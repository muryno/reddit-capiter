package com.muryno.domain.usecase

import com.muryno.domain.gateway.GetRedditDbRepository

class DeleteFavouritePostUseCase(private val getRedditRepository: GetRedditDbRepository) {
    fun call(postId: String) = getRedditRepository.clearSingleReddit(postId)
}
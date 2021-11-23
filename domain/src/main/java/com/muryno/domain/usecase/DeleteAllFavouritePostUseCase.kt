package com.muryno.domain.usecase

import com.muryno.domain.gateway.GetRedditDbRepository

class DeleteAllFavouritePostUseCase (private val getRedditRepository: GetRedditDbRepository) {
    fun call()= getRedditRepository.clearReddit()
}
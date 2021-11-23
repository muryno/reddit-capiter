package com.muryno.reddits.presenter.di.module


import com.muryno.domain.gateway.GetRedditDbRepository
import com.muryno.domain.gateway.GetRedditRepository
import com.muryno.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideDeleteAllFavouritePostUseCase(getRedditRepository: GetRedditDbRepository) =
        DeleteAllFavouritePostUseCase(getRedditRepository)

    @Provides
    fun provideDeleteFavouritePostUseCase(getRedditRepository: GetRedditDbRepository) =
        DeleteFavouritePostUseCase(getRedditRepository)

    @Provides
    fun provideGetAllFavouritePostUseCase(getRedditRepository: GetRedditDbRepository) =
        GetAllFavouritePostUseCase(getRedditRepository)

    @Provides
    fun provideGetAllRedditPostUseCase(getRedditRepository: GetRedditRepository) =
        GetAllRedditPostUseCase(getRedditRepository)

    @Provides
    fun provideSaveFavouritePostUseCase(getRedditRepository: GetRedditDbRepository) =
        SaveFavouritePostUseCase(getRedditRepository)

}
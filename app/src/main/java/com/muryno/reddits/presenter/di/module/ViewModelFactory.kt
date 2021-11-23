package com.muryno.reddits.presenter.di.module

import androidx.lifecycle.ViewModelProvider
import com.muryno.domain.usecase.*
import com.muryno.reddits.presenter.viewmodel.DetailsViewModelFactory
import com.muryno.reddits.presenter.viewmodel.FavouriteFragmentRedditViewModelFactory
import com.muryno.reddits.presenter.viewmodel.HomeFragmentRedditViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelFactory{

    @Singleton
    @Provides
    fun providerHomeFragmentRedditViewModelFactory(
        getAllRedditPostUseCase: GetAllRedditPostUseCase,
        ): ViewModelProvider.Factory {
        return HomeFragmentRedditViewModelFactory(
            getAllRedditPostUseCase = getAllRedditPostUseCase,
        )
    }

    @Singleton
    @Provides
    fun providerFavouriteFragmentRedditViewModelFactory(
        deleteAllFavouritePostUseCase: DeleteAllFavouritePostUseCase,
         getAllFavouritePostUseCase : GetAllFavouritePostUseCase,
          deleteFavouritePostUseCase : DeleteFavouritePostUseCase,
    ): ViewModelProvider.Factory {
        return FavouriteFragmentRedditViewModelFactory(
            deleteAllFavouritePostUseCase = deleteAllFavouritePostUseCase,
            getAllFavouritePostUseCase=getAllFavouritePostUseCase,
            deleteFavouritePostUseCase=deleteFavouritePostUseCase
        )
    }

    @Singleton
    @Provides
    fun providerDetailsViewModelFactory(
        saveFavouritePostUseCase : SaveFavouritePostUseCase
    ): ViewModelProvider.Factory {
        return DetailsViewModelFactory(
            saveFavouritePostUseCase = saveFavouritePostUseCase,
        )
    }
}
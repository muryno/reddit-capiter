package com.muryno.reddits.presenter.di.module

import android.app.Application
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
          context: Application
    ): ViewModelProvider.Factory {
        return FavouriteFragmentRedditViewModelFactory(
            deleteAllFavouritePostUseCase = deleteAllFavouritePostUseCase,
            getAllFavouritePostUseCase=getAllFavouritePostUseCase,
                    context=context
        )
    }

    @Singleton
    @Provides
    fun providerDetailsViewModelFactory(
        saveFavouritePostUseCase : SaveFavouritePostUseCase,
        deleteFavouritePostUseCase : DeleteFavouritePostUseCase,

        context:  Application
    ): ViewModelProvider.Factory {
        return DetailsViewModelFactory(
            saveFavouritePostUseCase = saveFavouritePostUseCase,
            deleteFavouritePostUseCase = deleteFavouritePostUseCase,
            context=context
        )
    }
}
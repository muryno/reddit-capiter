package com.muryno.reddits.presenter.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muryno.domain.usecase.DeleteAllFavouritePostUseCase
import com.muryno.domain.usecase.DeleteFavouritePostUseCase
import com.muryno.domain.usecase.GetAllFavouritePostUseCase
import com.muryno.domain.usecase.GetAllRedditPostUseCase
import javax.inject.Inject


class FavouriteFragmentRedditViewModelFactory @Inject constructor(private val deleteAllFavouritePostUseCase: DeleteAllFavouritePostUseCase,
                                                                  private val getAllFavouritePostUseCase : GetAllFavouritePostUseCase,
                                                                  private val context: Application
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavouriteFragmentRedditViewModel::class.java)) {
            return FavouriteFragmentRedditViewModel(
                deleteAllFavouritePostUseCase,
                getAllFavouritePostUseCase,
                context=context
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
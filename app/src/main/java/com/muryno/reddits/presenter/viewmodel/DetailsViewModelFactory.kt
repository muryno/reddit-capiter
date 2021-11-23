package com.muryno.reddits.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muryno.domain.usecase.DeleteFavouritePostUseCase
import com.muryno.domain.usecase.GetAllRedditPostUseCase
import com.muryno.domain.usecase.SaveFavouritePostUseCase
import javax.inject.Inject


class DetailsViewModelFactory @Inject constructor(private val saveFavouritePostUseCase : SaveFavouritePostUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(
                saveFavouritePostUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
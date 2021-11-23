package com.muryno.reddits.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muryno.domain.usecase.GetAllRedditPostUseCase
import javax.inject.Inject


class HomeFragmentRedditViewModelFactory @Inject constructor(private val getAllRedditPostUseCase: GetAllRedditPostUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeFragmentRedditViewModel::class.java)) {
            return HomeFragmentRedditViewModel(
                getAllRedditPostUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
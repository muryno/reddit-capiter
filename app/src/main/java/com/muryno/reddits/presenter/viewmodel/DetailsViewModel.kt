package com.muryno.reddits.presenter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.filter
import androidx.paging.rxjava2.cachedIn
import com.muryno.data.mapper.RedditListMapper
import com.muryno.domain.entiity.RedditPostEntity
import com.muryno.domain.usecase.*
import com.muryno.reddits.presenter.utils.showToast

import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class DetailsViewModel @Inject constructor(
    private val saveFavouritePostUseCase : SaveFavouritePostUseCase
) : ViewModel() {
    fun saveFavouritePostUseCase( post: RedditPostEntity ) {
        post.isFavourite = 1
        saveFavouritePostUseCase.call(post)


    }
}






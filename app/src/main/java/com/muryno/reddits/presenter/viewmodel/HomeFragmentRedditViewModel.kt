package com.muryno.reddits.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.filter
import androidx.paging.rxjava2.cachedIn
import com.muryno.domain.entiity.RedditPostEntity
import com.muryno.domain.usecase.GetAllRedditPostUseCase

import io.reactivex.Flowable
import javax.inject.Inject


class HomeFragmentRedditViewModel @Inject constructor(
    private val getAllRedditPostUseCase: GetAllRedditPostUseCase,
) : ViewModel() {


    //initial loading
    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading


    fun getRedditPost(): Flowable<PagingData<RedditPostEntity>> {
        _loading.postValue(true)
        return getAllRedditPostUseCase
            .call()
            .map { pagingData -> pagingData.filter { it.author != null } }
            .cachedIn(viewModelScope)
    }
}






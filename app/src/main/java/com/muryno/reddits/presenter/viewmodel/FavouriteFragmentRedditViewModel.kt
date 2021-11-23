package com.muryno.reddits.presenter.viewmodel

import androidx.lifecycle.LiveData
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
import com.muryno.reddits.presenter.adapter.FavouritePostAdapter

import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class FavouriteFragmentRedditViewModel @Inject constructor(
    private val deleteAllFavouritePostUseCase: DeleteAllFavouritePostUseCase,
    private val getAllFavouritePostUseCase : GetAllFavouritePostUseCase,
    private val deleteFavouritePostUseCase : DeleteFavouritePostUseCase,
) : ViewModel() {

    private var mDisposable : Disposable ?= null




    var post:  List<RedditPostEntity> = arrayListOf()

    //show empty state
    private val _emptyState: MutableLiveData<Boolean> = MutableLiveData()
    val emptyState: LiveData<Boolean> = _emptyState


    private val _favouriteResult: MutableLiveData<List<RedditPostEntity>> = MutableLiveData()
    val favouriteResult: LiveData<List<RedditPostEntity>> = _favouriteResult




    fun getRedditFavouritePost() {
        mDisposable =  getAllFavouritePostUseCase
            .call()
            .subscribe {result->
                if(result.isNotEmpty()) {
                    post = result
                    _favouriteResult.postValue(result)
                }
                showEmptyView(result.isEmpty())
            }
    }



    fun deleteAllFavourite(){
        deleteAllFavouritePostUseCase.call()
        getRedditFavouritePost()
    }



    fun deleteAllFavourite(postId: Int){
        deleteFavouritePostUseCase.call(postId)
        getRedditFavouritePost()
    }



    fun showEmptyView(empty: Boolean) {
        if (empty)
            _emptyState.postValue(true)
        else
            _emptyState.postValue(false)
    }

    override fun onCleared() {
        super.onCleared()
        mDisposable?.dispose()
    }
}






package com.muryno.reddits.presenter.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muryno.domain.entiity.RedditPostEntity
import com.muryno.domain.usecase.DeleteAllFavouritePostUseCase
import com.muryno.domain.usecase.GetAllFavouritePostUseCase
import com.muryno.reddits.R
import com.muryno.reddits.presenter.utils.showToast
import io.reactivex.disposables.Disposable


class FavouriteFragmentRedditViewModel (
    private val deleteAllFavouritePostUseCase: DeleteAllFavouritePostUseCase,
    private val getAllFavouritePostUseCase : GetAllFavouritePostUseCase,
    private val context: Application
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
                }else {
                    _favouriteResult.postValue(listOf())
                    showEmptyView(result.isEmpty())
                }
            }
    }

    fun deleteAllFavourite(){
        deleteAllFavouritePostUseCase.call()
        getRedditFavouritePost()
        showToast(context.applicationContext,context.getString( R.string.delete_all_post))
    }






    private fun showEmptyView(empty: Boolean) {
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






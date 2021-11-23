package com.muryno.reddits.presenter.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.muryno.domain.entiity.RedditPostEntity
import com.muryno.domain.usecase.DeleteFavouritePostUseCase
import com.muryno.domain.usecase.SaveFavouritePostUseCase
import com.muryno.reddits.R
import com.muryno.reddits.presenter.utils.showToast


class DetailsViewModel(
    private val saveFavouritePostUseCase: SaveFavouritePostUseCase,
    private val deleteFavouritePostUseCase: DeleteFavouritePostUseCase,
    private val context: Application
) : ViewModel() {

    fun saveFavouritePostUseCase(post: RedditPostEntity) {
        saveFavouritePostUseCase.call(post)
        showToast(context.applicationContext, context.getString(R.string.post_success_message))
    }


    fun deleteAllFavourite(postId: String) {
        deleteFavouritePostUseCase.call(postId)
        showToast(context.applicationContext, context.getString(R.string.delete_message))
    }
}






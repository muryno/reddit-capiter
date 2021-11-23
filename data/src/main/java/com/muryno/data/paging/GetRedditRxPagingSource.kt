package com.muryno.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.muryno.data.mapper.RedditListMapper
import com.muryno.data.remote.RedditRemoteDataSource
import com.muryno.data.repository.RedditRemoteRepository
import com.muryno.domain.entiity.RedditListEntity
import com.muryno.domain.entiity.RedditPostEntity
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException
import java.io.InvalidObjectException
import javax.inject.Inject

class GetRedditRxPagingSource  @Inject constructor(
    private val service: RedditRemoteRepository,
) : RxPagingSource<String, RedditPostEntity>() {
    override fun loadSingle(params: LoadParams<String>): Single<LoadResult<String, RedditPostEntity>> {
        return service.getRedditApi(page = params.loadSize,after = if (params is LoadParams.Append) params.key else "poo",t="all",
            before = if (params is LoadParams.Prepend) params.key else "",)
            .subscribeOn(Schedulers.io())
            .map {
                RedditListMapper.transformFrom(it)
            }
            .map<LoadResult<String, RedditPostEntity>> { result ->
                LoadResult.Page(
                    data = result.children,
                    prevKey = result.before,
                    nextKey = result.after
                )
            }
            .onErrorReturn { e ->
                when (e) {
                    is IOException -> LoadResult.Error(e)
                    is HttpException -> LoadResult.Error(e)
                    is InvalidObjectException ->LoadResult.Error(e)
                    is Exception ->LoadResult.Error(e)
                    else -> throw e
                }
            }
    }

    @ExperimentalPagingApi
    override fun getRefreshKey(state: PagingState<String, RedditPostEntity>): String? {
        return  state.anchorPosition?.let { state.closestItemToPosition(it)?.id }
    }
}
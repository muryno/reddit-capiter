package com.muryno.data.remote.api

import com.muryno.data.models.RedditApiResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditService {

    @GET("r/aww/top.json?")
    fun getRedditApi(
        @Query("limit") page: Int = 0,
        @Query("after") after: String ,
        @Query("t") t: String ,
    ): Single<RedditApiResponse>



    @GET("r/aww/search.json")
    fun getSearchedRedditFromApi(
        @Query("limit") page: Int = 0,
        @Query("after") after: String ,
        @Query("q") query: String ,
        @Query("t") t: String = "all" ,
    ): Single<RedditApiResponse>

}
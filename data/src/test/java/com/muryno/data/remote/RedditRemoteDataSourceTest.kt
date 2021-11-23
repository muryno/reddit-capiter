package com.muryno.data.remote


import com.google.common.truth.Truth
import com.muryno.data.remote.api.RedditService
import com.muryno.data.utils.TestData
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@Suppress("IllegalIdentifier")
@RunWith(MockitoJUnitRunner::class)
class RedditRemoteDataSourceTest{

    @Mock
    private lateinit var redditService: RedditService
    private lateinit var redditRemoteDataSource: RedditRemoteDataSource
    val pageSize =25
    val after = "foo"
    val query= "cat"
    val t = "q"
    @Before
    fun setup(){
        redditRemoteDataSource = RedditRemoteDataSource(redditService)
    }

    @Test
    @Throws(Exception::class)
    fun `test fetch Reddit From Api return data`(){

        val response = Single.just(TestData.getRedditApiResponse())
        //when
        Mockito.`when`(redditRemoteDataSource.getRedditApi(
            page = pageSize,after = after,t = "q",before = "")).thenReturn(response)

        val request = redditService.getRedditApi(page = pageSize,after = "poo",t = t)

        //should
        Truth.assertThat(request).isNotEqualTo(null)
        Truth.assertThat(request.blockingGet()).isEqualTo(response.blockingGet())
    }

    @Test
    @Throws(Exception::class)
    fun `test Searched Reddit From Api return data`(){

        val response = Single.just(TestData.getRedditApiResponse())
        //when
        Mockito.`when`(redditRemoteDataSource.getSearchedRedditFromApi(
            page = pageSize,after = after,t = t,query = query)).thenReturn(response)

        val request = redditService.getSearchedRedditFromApi(page = pageSize,after = after,t = t,query = query)

        //should
        Truth.assertThat(request).isNotEqualTo(null)
        Truth.assertThat(request.blockingGet()).isEqualTo(response.blockingGet())

    }
}
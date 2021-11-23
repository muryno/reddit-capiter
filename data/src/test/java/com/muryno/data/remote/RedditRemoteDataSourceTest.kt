package com.muryno.data.remote


import com.google.common.truth.Truth
import com.muryno.data.models.RedditApiResponse
import com.muryno.data.remote.RedditRemoteDataSource
import com.muryno.data.remote.api.RedditService
import com.muryno.data.repository.RedditRemoteRepository
import com.muryno.data.utils.TestData
import com.muryno.domain.entiity.RedditPostEntity
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
    @Before
    fun setup(){
        redditRemoteDataSource = RedditRemoteDataSource(redditService)
    }

    @Test
    @Throws(Exception::class)
    fun `get detail of the  success will return the details`(){

        val result = Single.just(TestData.getRedditApiResponse())
        //when
        Mockito.`when`(redditRemoteDataSource.getRedditApi(
            page = pageSize,after = "poo",t = "q",before = "")).thenReturn(result)

        val response = redditService.getRedditApi(page = pageSize,after = "poo",t = "q")

        //should
        Truth.assertThat(response).isNotEqualTo(null)


        Assert.assertNotNull(response)
        Truth.assertThat(result.blockingGet()).isEqualTo(response.blockingGet())
        //also check the size of the list will be 1
        Truth.assertThat(result.blockingGet().data.dist).isEqualTo(1)
    }

}
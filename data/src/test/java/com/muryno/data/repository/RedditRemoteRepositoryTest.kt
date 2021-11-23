package com.muryno.data.repository


import com.google.common.truth.Truth
import com.muryno.data.remote.RedditRemoteDataSource
import com.muryno.data.repository.RedditRemoteRepository
import com.muryno.data.utils.TestData
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@Suppress("IllegalIdentifier")
@RunWith(MockitoJUnitRunner::class)
class RedditRemoteRepositoryTest{

    @Mock
    private lateinit var remoteDataSource: RedditRemoteDataSource
    private lateinit var redditRemoteRepository: RedditRemoteRepository
    val pageSize =25
    @Before
    fun setup(){
        redditRemoteRepository = RedditRemoteRepository(remoteDataSource)
    }

    @Test
    @Throws(Exception::class)
    fun `get detail of the movie response success will return the details`(){



        //Given
        val data = TestData.getRedditApiResponse()
        val testResponse = Single.just(data)
        Mockito.`when`(remoteDataSource.getRedditApi(page = pageSize,after = "poo",before = "",t = "q"))
            .thenReturn(Single.just(
                data
        ))

        //When
        val testRequest = remoteDataSource.getRedditApi(page = pageSize,after = "poo",before = "",t = "q")

        //should
        Truth.assertThat(testRequest.blockingGet()).isEqualTo(testResponse.blockingGet())
    }

    @Test
    @Throws(Exception::class)
    fun `getReddit returns null if response is null`(){

        //Given
        val response =TestData.getRedditApiResponse()
        Mockito.`when`(remoteDataSource.getRedditApi(page = pageSize,after = "poo",before = "",t = "q")).thenReturn(null)

        //when
        val testObserver = remoteDataSource.getRedditApi(page = pageSize,after = "poo",before = "",t = "q")

        //should
        Truth.assertThat(testObserver).isEqualTo(null)
    }
}
package com.muryno.data.repository


import com.google.common.truth.Truth
import com.muryno.data.remote.RedditCacheDataSource
import com.muryno.data.utils.TestData
import com.muryno.domain.entiity.RedditPostEntity
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@Suppress("IllegalIdentifier")
@RunWith(MockitoJUnitRunner::class)
class RedditCacheRepositoryTest{

    @Mock
    private lateinit var remoteDataSource: RedditCacheDataSource
    private lateinit var redditRemoteRepository: RedditCacheRepository
    val pageSize =25
    @Before
    fun setup(){
        redditRemoteRepository = RedditCacheRepository(remoteDataSource)
    }

    @Test
    @Throws(Exception::class)
    fun `get list of favourite reddit from local database will return data`(){

        val response =  Single.just(
            TestData.getRedditPostEntityList()
        )
        //Given
        Mockito.`when`(remoteDataSource.fetchAllFavouritePost())
            .thenReturn(response)

        //When
        val request = remoteDataSource.fetchAllFavouritePost()


        //should
        Truth.assertThat(request.blockingGet() ).isEqualTo(response.blockingGet())
    }

    @Test
    @Throws(Exception::class)
    fun `getReddit returns null if response is null`(){

        //Given
        Mockito.`when`(remoteDataSource.fetchAllFavouritePost())
            .thenReturn(null)
        //when
        val testResult = remoteDataSource.fetchAllFavouritePost()
        //should
        Truth.assertThat(testResult).isEqualTo(null)
    }


    @Test
    @Throws(Exception::class)
    fun `test saved data`(){
        //Given
        val post = Single.just(TestData.getRedditPostModelList())
        val testResponse : Single<List<RedditPostEntity>> =Single.just(
            TestData.getRedditPostEntityList()
        )


        Mockito.`when`(remoteDataSource.transformListRedditPostModelToRedditPostEntity(post))
            .thenReturn(Single.just(
                TestData.getRedditPostEntityList()
            ))

        //When
        val testResult  = remoteDataSource.transformListRedditPostModelToRedditPostEntity(post)


        //should
        Truth.assertThat(testResult.blockingGet() ).isEqualTo(testResponse.blockingGet())


    }

}
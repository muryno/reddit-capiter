package com.muryno.data.gateway

import com.google.common.truth.Truth
import com.muryno.data.repository.RedditCacheRepository
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
class GetRedditDataBaseImplTest {

    @Mock
    private lateinit var remoteDataSource: RedditCacheRepository

    private lateinit var getRedditDataBaseImpl: GetRedditDataBaseImpl

    @Before
    fun setup() {
        getRedditDataBaseImpl = GetRedditDataBaseImpl(remoteDataSource)
    }

    @Test
    @Throws(Exception::class)
    fun `get list of favourite reddit from local database will return data`() {

        val response = Single.just(
            TestData.getRedditPostEntityList()
        )
        //Given
        Mockito.`when`(getRedditDataBaseImpl.fetchAllFavouritePost())
            .thenReturn(
                response
            )

        //When
        val request = getRedditDataBaseImpl.fetchAllFavouritePost()


        //should
        Truth.assertThat(request.blockingGet()).isEqualTo(response.blockingGet())
    }

}
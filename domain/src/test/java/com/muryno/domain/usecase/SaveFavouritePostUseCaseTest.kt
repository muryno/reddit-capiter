package com.muryno.domain.usecase

import com.google.common.truth.Truth
import com.muryno.domain.gateway.GetRedditDbRepository
import com.muryno.domain.utils.TestData
import com.muryno.domain.utils.TestData.getRedditPostEntity
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SaveFavouritePostUseCaseTest {

    @Mock
    private lateinit var getRedditDbRepository: GetRedditDbRepository
    private lateinit var saveFavouritePostUseCase: SaveFavouritePostUseCase
    val pageSize = 25

    @Before
    fun setup() {
        saveFavouritePostUseCase = SaveFavouritePostUseCase(getRedditDbRepository)
    }

    @Test
    @Throws(Exception::class)
    fun `get detail of the movie response success will return the details`() {

        val response = Single.just(TestData.getRedditPostEntityList())
        val input = getRedditPostEntity()
        //when
        Mockito.`when`(getRedditDbRepository.fetchAllFavouritePost()).thenReturn(null)

        //then
        Truth.assertThat(response).isNotEqualTo(null)

        //when
        Mockito.`when`(getRedditDbRepository.fetchAllFavouritePost()).thenReturn(response)

        //save
        saveFavouritePostUseCase.call(input)

        //fetch
        val request = getRedditDbRepository.fetchAllFavouritePost()

        //should
        Truth.assertThat(request).isNotEqualTo(null)

        Truth.assertThat(request.blockingGet()).isEqualTo(response.blockingGet())

    }

}
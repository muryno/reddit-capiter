package com.muryno.domain.usecase

import com.google.common.truth.Truth
import com.muryno.domain.gateway.GetRedditDbRepository
import com.muryno.domain.utils.TestData
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetAllRedditPostUseCaseTest {

    @Mock
    private lateinit var getRedditRepository: GetRedditDbRepository
    private lateinit var getAllFavouritePostUseCase: GetAllFavouritePostUseCase
    val pageSize = 25

    @Before
    fun setup() {
        getAllFavouritePostUseCase = GetAllFavouritePostUseCase(getRedditRepository)
    }

    @Test
    @Throws(Exception::class)
    fun `get detail of the movie response success will return the details`() {

        val response = Single.just(TestData.getRedditPostEntityList())
        //when
        Mockito.`when`(getRedditRepository.fetchAllFavouritePost()).thenReturn(response)

        val request = getAllFavouritePostUseCase.call()

        //should
        Truth.assertThat(request).isNotEqualTo(null)
        Truth.assertThat(request.blockingGet()).isEqualTo(response.blockingGet())

    }

}
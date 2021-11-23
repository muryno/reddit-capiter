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
class DeleteAllPostUseCaseTest {

    @Mock
    private lateinit var getRedditDbRepository: GetRedditDbRepository
    private lateinit var deleteAllFavouritePostUseCase: DeleteAllFavouritePostUseCase
    val pageSize =25
    @Before
    fun setup(){
        deleteAllFavouritePostUseCase = DeleteAllFavouritePostUseCase(getRedditDbRepository)
    }

    @Test
    @Throws(Exception::class)
    fun `dele`(){

        val response = Single.just(TestData.getRedditPostEntityList())
        val input = getRedditPostEntity()


        //when
        Mockito.`when`(getRedditDbRepository.fetchAllFavouritePost()).thenReturn(response)


        //fetch
        val request = getRedditDbRepository.fetchAllFavouritePost()

        //should
        Truth.assertThat(request).isNotEqualTo(null)

        Truth.assertThat(request.blockingGet()).isEqualTo(response.blockingGet())


        //save
        deleteAllFavouritePostUseCase.call()

        //when
        Mockito.`when`(getRedditDbRepository.fetchAllFavouritePost()).thenReturn(null)

        //then
        Truth.assertThat(response).isNotEqualTo(null)


    }

}
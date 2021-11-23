package com.muryno.domain.usecase

import androidx.paging.PagingData
import com.muryno.domain.gateway.GetRedditRepository
import com.muryno.domain.utils.getRedditPostEntity
import io.reactivex.Flowable
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
    private lateinit var getRedditRepository: GetRedditRepository
    private lateinit var getAllRedditPostUseCase: GetAllRedditPostUseCase
    val pageSize =25
    @Before
    fun setup(){
        getAllRedditPostUseCase = GetAllRedditPostUseCase(getRedditRepository)
    }

    @Test
    @Throws(Exception::class)
    fun `get detail of the movie response success will return the details`(){



    }

}
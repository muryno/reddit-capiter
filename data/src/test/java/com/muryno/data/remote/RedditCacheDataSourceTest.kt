package com.muryno.data.remote


import com.google.common.truth.Truth
import com.muryno.data.remote.db.dao.RedditDao
import com.muryno.data.utils.TestData
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class RedditCacheDataSourceTest {

    @Mock
    private lateinit var redditDao: RedditDao

    private lateinit var redditCacheDataSource: RedditCacheDataSource
    val pageSize = 25

    @Before
    fun setup() {
        redditCacheDataSource = RedditCacheDataSource(redditDao)
    }

    @Test
    @Throws(Exception::class)
    fun `test transform List RedditPostModel To RedditPostEntity`() {

        val response = Single.just(TestData.getRedditPostEntityList())
        val input = Single.just(TestData.getRedditPostModelList())
        //when

        val request = redditCacheDataSource.transformListRedditPostModelToRedditPostEntity(input)

        //should
        Truth.assertThat(request.blockingGet()).isNotEqualTo(null)

        Truth.assertThat(request.blockingGet()).isEqualTo(response.blockingGet())

    }

    @Test
    @Throws(Exception::class)
    fun `test transform RedditPostModel To RedditPostEntity`() {

        val input = TestData.getRedditPostEntity()
        val response = TestData.getRedditPostModel()
        //when

        val request = redditCacheDataSource.transformRedditPostModelToRedditPostEntity(input)

        //should
        Truth.assertThat(request).isNotEqualTo(null)

        Truth.assertThat(request).isEqualTo(response)
    }


}
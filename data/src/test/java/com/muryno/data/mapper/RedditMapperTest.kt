package com.muryno.data.mapper


import com.google.common.truth.Truth
import com.muryno.data.utils.TestData
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RedditMapperTest {

    @Test
    fun `data transform RedditListEntity to RedditApiResponse`() {
        //given
        val dataResponse = TestData.getRedditApiResponse()
        val response = TestData.getRedditCollection()

        //when
        val request = RedditListMapper.transformFrom(dataResponse)

        //Then
        Truth.assertThat(request.dist).isEqualTo(response.dist)
    }

    @Test
    fun `test transform RedditModel To Domain Mapper`() {
        //given
        val dataResponse = TestData.getRedditPostEntity()
        val response = TestData.getRedditPostModel()

        //when
        val request = RedditModelToDomainMapper.transformFrom(dataResponse)

        //Then
        Truth.assertThat(request).isEqualTo(response)
    }

    @Test
    fun `test transform from  RedditModel ToDomain Mapper`() {
        //given
        val  response= TestData.getRedditPostEntity()
        val dataResponse = TestData.getRedditPostModel()

        //when
        val request = RedditModelToDomainMapper.transformTo(dataResponse)

        //Then
        Truth.assertThat(request).isEqualTo(response)
    }




}
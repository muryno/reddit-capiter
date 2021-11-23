package com.muryno.data.util

import com.muryno.data.models.RedditPostModel
import com.muryno.data.models.mapToDomain
import com.muryno.domain.entiity.RedditPostEntity


abstract class BaseMapper<T, K> {

    abstract fun transformFrom(source: K): T

    abstract fun transformTo(source: T): K

    fun transformFromList(source: List<K>?): List<T> {
        return source?.map { src -> transformFrom(src) } ?: emptyList()
    }
    fun transformToList(source: List<T>): List<K> {
        return source.map { src -> transformTo(src) }
    }

    fun List<RedditPostModel>.mapLisToDomain() : List<RedditPostEntity>
            = map { it.mapToDomain() }

    fun toList(source: List<T>):List<K> = source.map { src -> transformTo(src) }

}
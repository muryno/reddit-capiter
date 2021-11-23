package com.muryno.data.remote.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muryno.data.remote.db.dao.RedditDao
import com.muryno.data.models.RedditKeys
import com.muryno.data.models.RedditPostModel


@Database(
    entities = [RedditPostModel::class],
    version = 1,
    exportSchema = false
)
abstract class RedditDBDatabase : RoomDatabase() {
    abstract fun redditDao(): RedditDao
}
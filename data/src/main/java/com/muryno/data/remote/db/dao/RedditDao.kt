package com.muryno.data.remote.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.muryno.data.models.RedditPostModel
import io.reactivex.Single

@Dao
interface RedditDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFavouritePosts(redditModel: RedditPostModel)

    @Query("SELECT * FROM reddit_Posts ")
    fun selectReddit(): Single<List<RedditPostModel>>

    @Query("DELETE FROM reddit_Posts")
    fun clearReddit()

    @Query("DELETE FROM reddit_Posts where id =:id")
    fun clearSingleReddit(id: String)
}
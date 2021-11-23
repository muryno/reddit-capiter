package com.muryno.data.mapper

import com.muryno.data.models.RedditApiResponse
import com.muryno.data.models.RedditListing
import com.muryno.data.models.RedditPostModel
import com.muryno.data.util.BaseMapper
import com.muryno.domain.entiity.RedditListEntity
import com.muryno.domain.entiity.RedditPostEntity

object RedditListMapper: BaseMapper<RedditListEntity, RedditApiResponse>() {
    override fun transformFrom(source: RedditApiResponse): RedditListEntity {
        return RedditListEntity(
            children = RedditModelToDomainMapper.transformToList(source.data.children.map { it.data }),
            dist = source.data.dist,
            after = source.data.after,
            before = source.data.before
        )

    }

    override fun transformTo(source: RedditListEntity): RedditApiResponse {
        return RedditApiResponse(
           data = RedditListing(
               children = listOf(),
               dist = source.dist,
               after = source.after,
               before = source.before
           )
        )
    }
}

object RedditModelToDomainMapper: BaseMapper<RedditPostModel, RedditPostEntity>(){
    override fun transformFrom(source: RedditPostEntity): RedditPostModel =
        RedditPostModel(
            id = source.id,
            key =source.key ,
            title=source.title ,
            score =source.score ,
            author =source.author,
            num_comments = source.num_comments,
            author_fullname =source.author_fullname,
            name = source.name,
            total_awards_received =source.total_awards_received,
            thumbnail = source.thumbnail,
            post_hint= source.post_hint,
            url_overridden_by_dest =source.url_overridden_by_dest,
            is_video = source.is_video,
            url = source.url,
            parent_whitelist_status=source.parent_whitelist_status,
            author_is_blocked=source.author_is_blocked,
            subreddit_type =source.subreddit_type ,
            isFavourite = source.isFavourite
        )

    override fun transformTo(source: RedditPostModel): RedditPostEntity =
        RedditPostEntity(
            id = source.id,
            key =source.key ,
            title=source.title ,
            score =source.score ,
            author =source.author,
            num_comments = source.num_comments,
            author_fullname =source.author_fullname,
            name = source.name,
            total_awards_received =source.total_awards_received,
            thumbnail = source.thumbnail,
            post_hint= source.post_hint,
            url_overridden_by_dest =source.url_overridden_by_dest,
            is_video = source.is_video,
            url = source.url,
            parent_whitelist_status=source.parent_whitelist_status,
            author_is_blocked=source.author_is_blocked,
            subreddit_type =source.subreddit_type ,)


}
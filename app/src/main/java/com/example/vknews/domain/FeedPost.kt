package com.example.vknews.domain

import com.example.vknews.R

data class FeedPost(
    val communityName: String = "уволено",
    val publicationDate: String = "14:00",
    val avatarResId: Int = R.drawable.post_comunity_thumbnail,
    val contentText: String = "X Window System, which is a networked windowing",
    val contentImageResId: Int = R.drawable.post_content_image,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, count = 206),
        StatisticItem(type = StatisticType.SHARES, count = 206),
        StatisticItem(type = StatisticType.COMMENTS, count = 11),
        StatisticItem(type = StatisticType.LIKES, count = 491),
    )
)

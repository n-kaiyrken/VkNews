package com.example.vknews.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vknews.R
import com.example.vknews.domain.FeedPost
import com.example.vknews.domain.StatisticItem
import com.example.vknews.domain.StatisticType

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    feedPost: FeedPost,
    onViewsClickListener: (StatisticItem) -> Unit,
    onShareClickListener: (StatisticItem) -> Unit,
    onCommentClickListener: (StatisticItem) -> Unit,
    onLikeClickListener: (StatisticItem) -> Unit
) {
    Log.d("Check", "PostCard")
    Card(
        modifier = modifier,
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            PostHeader(feedPost)
            Text(
                text = feedPost.contentText,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
            Image(
                painter = painterResource(id = feedPost.contentImageResId),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(top = 10.dp),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(10.dp))
            PostStatistics(
                statistics = feedPost.statistics,
                onViewsClickListener = onViewsClickListener,
                onShareClickListener = onShareClickListener,
                onCommentClickListener = onCommentClickListener,
                onLikeClickListener = onLikeClickListener
            )
        }
    }
}

@Composable
private fun PostHeader(
    feedPost: FeedPost
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            painter = painterResource(id = feedPost.avatarResId),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier
                .height(60.dp)
                .weight(1f),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = feedPost.communityName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onPrimary
            )
            Text(
                text = feedPost.publicationDate,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MaterialTheme.colors.onSecondary
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = "",
            modifier = Modifier
                .size(40.dp),
            tint = MaterialTheme.colors.onSecondary
        )
    }
}

@Composable
fun PostStatistics(
    statistics: List<StatisticItem>,
    onViewsClickListener: (StatisticItem) -> Unit,
    onShareClickListener: (StatisticItem) -> Unit,
    onCommentClickListener: (StatisticItem) -> Unit,
    onLikeClickListener: (StatisticItem) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier.weight(1f)) {
            val viewsItem = statistics.getItemByType(StatisticType.VIEWS)
            IconWithText(
                value = viewsItem.count,
                image = R.drawable.ic_views,
                onItemClickListener ={
                    onViewsClickListener(viewsItem)
                }
            )
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val sharesItem = statistics.getItemByType(StatisticType.SHARES)
            IconWithText(
                value = sharesItem.count,
                image = R.drawable.ic_share,
                onItemClickListener ={
                    onShareClickListener(sharesItem)
                }
            )
            val commentItem = statistics.getItemByType(StatisticType.COMMENTS)
            IconWithText(
                value = commentItem.count,
                image = R.drawable.ic_comment,
                onItemClickListener ={
                    onCommentClickListener(commentItem)
                }
            )
            val likesItem = statistics.getItemByType(StatisticType.LIKES)
            IconWithText(
                value = likesItem.count,
                image = R.drawable.ic_like,
                onItemClickListener ={
                    onLikeClickListener(likesItem)
                }
            )
        }
    }
}

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
    return this.find { it.type == type } ?: throw IllegalStateException()
}

@Composable
fun IconWithText(value: Int, image: Int, onItemClickListener: () -> Unit) {
    Row(
        modifier = Modifier.clickable {
            onItemClickListener()
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = image),
            contentDescription = "icon",
            modifier = Modifier.padding(end = 5.dp),
            tint = MaterialTheme.colors.onSecondary
        )
        Text(
            text = value.toString(),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onSecondary,
            fontSize = 20.sp
        )
    }
}

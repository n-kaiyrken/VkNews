package com.example.vknews.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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

@Composable
fun VkNewsCard() {
    Card(
        modifier = Modifier
            .padding(10.dp),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            PostHeader()
            Text(
                text = stringResource(R.string.template_text),
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.post_content_image),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(10.dp))
            PostStatistics(
                viewsCount = 206,
                sharesCount = 206,
                commentsCount = 11,
                likesCount = 491
            )
        }
    }
}

@Composable
private fun PostHeader() {
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
            painter = painterResource(id = R.drawable.post_comunity_thumbnail),
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
                text = "уволено",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onPrimary
            )
            Text(
                text = "14:00",
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
    viewsCount: Int,
    sharesCount: Int,
    commentsCount: Int,
    likesCount: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier.weight(1f)) {
            Statistic(value = viewsCount, image = R.drawable.ic_views)
        }
        Statistic(value = sharesCount, image = R.drawable.ic_share)
        Spacer(modifier = Modifier.width(20.dp))
        Statistic(value = commentsCount, image = R.drawable.ic_comment)
        Spacer(modifier = Modifier.width(20.dp))
        Statistic(value = likesCount, image = R.drawable.ic_like)
    }
}

@Composable
fun Statistic(value: Int, image: Int) {
    Row(
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

@Preview
@Composable
fun PreviewLightCard() {
    VkNewsTheme(darkTheme = false) {
        VkNewsCard()
    }
}

@Preview
@Composable
fun PreviewDarkCard() {
    VkNewsTheme(darkTheme = true) {
        VkNewsCard()
    }
}

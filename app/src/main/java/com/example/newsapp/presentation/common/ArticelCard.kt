package com.example.newsapp.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.newsapp.R
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.model.Source
import com.example.newsapp.presentation.Dimnes.ExtraSmallPadding
import com.example.newsapp.presentation.Dimnes.ArticleCardSize
import com.example.newsapp.presentation.Dimnes.ExtraSmallPadding2
import com.example.newsapp.presentation.Dimnes.SmallIconSize
import com.example.newsapp.ui.theme.NewsAppTheme

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {

    val context = LocalContext.current

    Row(
        modifier = Modifier.clickable { onClick() }
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium)
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)
        ) {
            Text(
                text = article.content,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(R.color.text_title),

                    )
                Spacer(modifier.width(ExtraSmallPadding2))
                Icon(
                    painter = painterResource(R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize)
                )
                Spacer(modifier.width(ExtraSmallPadding2))

                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium,
                    color = colorResource(R.color.text_title),
                    )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ArticleCardPreview() {
    NewsAppTheme {
        ArticleCard(
            article = Article(
                author = "Author",
                content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Content number .",
                description = "This is a short description for article .",
                publishedAt = "2 hours",
                source = Source(
                    id = "source-",
                    name = "Source Name "
                ),
                title = "Dummy Article Title ",
                url = "https://example.com/article",
                urlToImage = "https://via.placeholder.com/150/0000FF/FFFFFF/?text=Image+"
            )
        ) { }
    }
}
package com.example.newsapp.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.newsapp.R
import com.example.newsapp.presentation.Dimnes.MediumPadding1
import com.example.newsapp.presentation.common.ArticleList
import com.example.newsapp.presentation.navgraph.Route

@Composable
fun BookmarkScreen(
    state: BookmarkState,
    navigate: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = MediumPadding1, start = MediumPadding1, end = MediumPadding1)
    ) {
        Text(
            text = "Bookmark",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(R.color.text_title)
        )
        Spacer(Modifier.height(MediumPadding1))
        ArticleList(articles = state.articles, onClick = {navigate(Route.DetailsScreen.route)})
    }

}
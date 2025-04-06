package com.example.newsapp.presentation.component

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.R
import com.example.newsapp.presentation.Dimnes.MediumPadding1
import com.example.newsapp.presentation.Dimnes.MediumPadding2
import com.example.newsapp.presentation.Page
import com.example.newsapp.presentation.pages
import com.example.newsapp.ui.theme.NewsAppTheme

@Composable
fun OnBoardingPage(modifier: Modifier = Modifier, page: Page) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f)
        )
        Spacer(modifier.height(MediumPadding1))
        Text(
            text = page.title,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(R.color.display_small),
            modifier = modifier.padding(horizontal = MediumPadding2)
        )
        Text(
            text = page.desc,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
            color = colorResource(R.color.text_medium),
            modifier = modifier.padding(horizontal = MediumPadding2)
        )
    }
}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun OnBoardingPagePreview() {
    NewsAppTheme {
        OnBoardingPage(page = pages[0])
    }
}
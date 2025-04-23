package com.example.newsapp.presentation.details.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.R
import com.example.newsapp.ui.theme.NewsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar(
    onShareClick: () -> Unit,
    onBookmarkClick: () -> Unit,
    onBrowsingClick: () -> Unit,
    onBackClick: () -> Unit,
) {

    TopAppBar(
        title = {},
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = colorResource(id = R.color.body),
            navigationIconContentColor = colorResource(id = R.color.body)
        ),
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(painterResource(R.drawable.ic_back_arrow), contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = onBrowsingClick) {
                Icon(painterResource(R.drawable.ic_network), contentDescription = null)
            }
            IconButton(onClick = onBookmarkClick) {
                Icon(painterResource(R.drawable.ic_bookmark), contentDescription = null)
            }
            IconButton(onClick = onShareClick) {
                Icon(imageVector = Icons.Default.Share, contentDescription = null)
            }
        }

    )

}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun DetailsTopBarPreview() {
    NewsAppTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            DetailsTopBar(
                onShareClick = { TODO() },
                onBookmarkClick = { TODO() },
                onBrowsingClick = { TODO() },
                onBackClick = { TODO() }
            )
        }
    }
}
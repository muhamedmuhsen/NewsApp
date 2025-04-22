package com.example.newsapp.presentation.search

import androidx.paging.PagingData
import com.example.newsapp.data.remote.dto.Article
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

data class SearchState(
    val searchQuery: String = "",
    val article: Flow<PagingData<Article>>? = null
)
package com.example.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val repo:NewsRepository
) {
    operator fun invoke(searchQuery: String,source:List<String>):Flow<PagingData<Article>>{
        return repo.searchNews(searchQuery = searchQuery, source = source)
    }
}
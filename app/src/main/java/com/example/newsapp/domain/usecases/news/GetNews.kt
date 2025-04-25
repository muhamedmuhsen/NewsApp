package com.example.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val repo:NewsRepository
) {
    operator fun invoke(source:List<String>): Flow<PagingData<Article>> {
        return repo.getNews(source)
    }
}
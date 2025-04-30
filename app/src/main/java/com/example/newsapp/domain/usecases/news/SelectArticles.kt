package com.example.newsapp.domain.usecases.news

import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val repo: NewsRepository
) {
     suspend operator fun invoke():Flow<List<Article>>{
      return repo.selectArticles()
    }
}
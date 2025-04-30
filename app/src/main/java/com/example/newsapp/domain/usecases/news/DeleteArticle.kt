package com.example.newsapp.domain.usecases.news

import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository

class DeleteArticle(
    private val repo: NewsRepository
) {
    suspend operator fun invoke(article: Article) {
        repo.deleteArticle(article)
    }
}
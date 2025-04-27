package com.example.newsapp.domain.usecases.news

import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.domain.model.Article

class GetArticle(
    private val dao: NewsDao
) {
    suspend operator fun invoke(url: String) {
        dao.getArticle(url)
    }
}
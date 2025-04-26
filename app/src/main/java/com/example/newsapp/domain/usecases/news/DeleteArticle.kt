package com.example.newsapp.domain.usecases.news

import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.domain.model.Article

class DeleteArticle(
    private val dao: NewsDao
) {
    suspend operator fun invoke(article: Article){
        dao.delete(article)
    }
}
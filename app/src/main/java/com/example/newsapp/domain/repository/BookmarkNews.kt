package com.example.newsapp.domain.repository

import com.example.newsapp.domain.model.Article

interface BookmarkNews {
    suspend fun bookmarkNews(article: Article)
}
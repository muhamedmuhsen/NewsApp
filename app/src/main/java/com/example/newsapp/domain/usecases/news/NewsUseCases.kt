package com.example.newsapp.domain.usecases.news

data class NewsUseCases(
    val newsUseCase: GetNews,
    val searchNews: SearchNews,
    val selectArticles:SelectArticles,
    val upsertArticle:UpsertArticle,
    val deleteArticle:DeleteArticle,
    val getArticle: GetArticle
)



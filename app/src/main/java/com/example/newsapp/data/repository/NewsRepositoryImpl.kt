package com.example.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.data.remote.NewsApi
import com.example.newsapp.data.remote.NewsPagingSource
import com.example.newsapp.data.remote.NewsSearchPagingSource
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewsRepositoryImpl(
    private val newsApi: NewsApi,
    private val dao :NewsDao
):NewsRepository {
    override fun getNews(source: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    source = source.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, source: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsSearchPagingSource(
                    newsApi = newsApi,
                    searchQuery=searchQuery,
                    source = source.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override suspend fun upsertNews(article: Article) {
        dao.upsert(article)
    }

    override suspend fun deleteArticle(article: Article) {
        dao.delete(article)
    }

    override suspend fun selectArticles(): Flow<List<Article>> {
       return dao.retrieve().map { it.reversed() }
    }

    override suspend fun selectArticle(url: String): Article? {
        return dao.getArticle(url)
    }
}
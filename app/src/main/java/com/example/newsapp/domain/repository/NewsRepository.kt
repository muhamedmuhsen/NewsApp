package com.example.newsapp.domain.repository

import androidx.paging.PagingData
import com.example.newsapp.data.remote.dto.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

     fun getNews(source:List<String>):Flow<PagingData<Article>>
}
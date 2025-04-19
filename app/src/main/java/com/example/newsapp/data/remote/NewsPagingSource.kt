package com.example.newsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newsapp.data.remote.dto.Article

class NewsPagingSource(
    private val newsApi: NewsApi,
    private val source: String
) : PagingSource<Int, Article>() {

    private var totalNewsCount = 0

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let {anchorPosition->
            val anchorPage= state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1

        return try {
            val newsResponse = newsApi.getNews(page=page, sources = source)
            totalNewsCount += newsResponse.articles.size
            val article = newsResponse.articles.distinctBy { it.title   }
            LoadResult.Page(
                data = article,
                prevKey = null,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }
}
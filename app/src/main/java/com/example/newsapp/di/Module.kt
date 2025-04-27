package com.example.newsapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.data.local.NewsDatabase
import com.example.newsapp.data.local.NewsTypeConverter
import com.example.newsapp.data.manager.LocalUserManagerImpl
import com.example.newsapp.data.remote.NewsApi
import com.example.newsapp.data.repository.NewsRepositoryImpl
import com.example.newsapp.domain.manager.LocalUserManager
import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.domain.usecases.appentry.ReadAppEntry
import com.example.newsapp.domain.usecases.appentry.SaveAppEntry
import com.example.newsapp.domain.usecases.news.DeleteArticle
import com.example.newsapp.domain.usecases.news.GetArticle
import com.example.newsapp.domain.usecases.news.GetNews
import com.example.newsapp.domain.usecases.news.NewsUseCases
import com.example.newsapp.domain.usecases.news.SearchNews
import com.example.newsapp.domain.usecases.news.SelectArticles
import com.example.newsapp.domain.usecases.news.UpsertArticle
import com.example.newsapp.util.Constants.BASE_URL
import com.example.newsapp.util.Constants.NEWS_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        @ApplicationContext context: Context
    ): LocalUserManager = LocalUserManagerImpl(context)

    @Provides
    @Singleton
    fun provideReadAppEntry(
        localUserManager: LocalUserManager
    ) = ReadAppEntry(localUserManager)

    @Provides
    @Singleton
    fun provideSaveAppEntry(
        localUserManager: LocalUserManager
    ) = SaveAppEntry(localUserManager)


    @Provides
    @Singleton
    fun provideApi(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsCases(
        repository: NewsRepository,
        dao: NewsDao
    ) = NewsUseCases(
        newsUseCase = GetNews(repository),
        searchNews = SearchNews(repository),
        selectArticles = SelectArticles(dao),
        upsertArticle = UpsertArticle(dao),
        deleteArticle = DeleteArticle(dao),
        getArticle = GetArticle(dao),
    )

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration() //fallbackToDestructiveMigration(false)
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        database: NewsDatabase
    ): NewsDao {
        return database.dao
    }
}
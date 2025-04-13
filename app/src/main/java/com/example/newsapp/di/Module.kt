package com.example.newsapp.di

import android.app.Application
import com.example.newsapp.data.manager.LocalUserManagerImpl
import com.example.newsapp.domain.manager.LocalUserManager
import com.example.newsapp.domain.usecases.ReadAppEntry
import com.example.newsapp.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun provideLocalUserManager(
       @ApplicationContext application: Application
    ):LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideReadAppEntry(
        localUserManager: LocalUserManager
    )= ReadAppEntry(localUserManager)

    @Provides
    @Singleton
    fun provideSaveAppEntry(
        localUserManager: LocalUserManager
    )= SaveAppEntry(localUserManager)

}
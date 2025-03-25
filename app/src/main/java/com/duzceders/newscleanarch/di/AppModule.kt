package com.duzceders.newscleanarch.di

import android.app.Application
import com.duzceders.newscleanarch.data.manager.LocalUserManagerImpl
import com.duzceders.newscleanarch.domain.manager.LocalUserManager
import com.duzceders.newscleanarch.domain.usecases.AppEntryUseCases
import com.duzceders.newscleanarch.domain.usecases.ReadAppEntry
import com.duzceders.newscleanarch.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}
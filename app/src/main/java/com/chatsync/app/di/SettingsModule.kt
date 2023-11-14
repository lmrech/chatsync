package com.chatsync.app.di

import com.chatsync.app.data.settings.SettingsRepository
import com.chatsync.app.domain.settings.SettingsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SettingsModule {
    @Provides
    @Singleton
    fun provideSettingsRepository(): SettingsService = SettingsRepository()
}
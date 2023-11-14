package com.chatsync.app.di

import com.chatsync.app.data.chat.ChatRepository
import com.chatsync.app.domain.chat.ChatService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ChatModule {
    @Provides
    @Singleton
    fun providesChatRepository(): ChatService = ChatRepository()
}
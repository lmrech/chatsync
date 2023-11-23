package com.chatsync.app.presentation.screen.home

import com.chatsync.app.domain.chat.ChatConversation
import com.chatsync.app.domain.settings.Settings

data class HomeUiState(
    val settings: Settings = Settings(),
    val conversations: List<ChatConversation> = emptyList()
)
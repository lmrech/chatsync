package com.chatsync.app.presentation.conversation.create

import com.chatsync.app.domain.chat.ChatMessage

data class CreateConversationUiState(
    val name: String = "",
    val messages: List<ChatMessage> = emptyList()
) {
    fun isCreateButtonEnabled(): Boolean {
        return name.isNotEmpty() && messages.isNotEmpty()
    }
}
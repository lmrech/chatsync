package com.chatsync.app.domain.chat

import kotlinx.coroutines.flow.StateFlow

interface ChatService {
    val conversations: StateFlow<List<ChatConversation>>
    fun createConversation(
        name: String,
        messages: List<ChatMessage>
    )
}
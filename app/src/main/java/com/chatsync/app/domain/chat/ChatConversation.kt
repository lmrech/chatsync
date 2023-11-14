package com.chatsync.app.domain.chat

data class ChatConversation(
    val id: Int,
    val name: String,
    val messages: List<ChatMessage>,
    val isDeleted: Boolean = false
    )
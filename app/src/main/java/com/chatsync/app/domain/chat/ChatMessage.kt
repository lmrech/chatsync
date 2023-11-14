package com.chatsync.app.domain.chat

data class ChatMessage(
    val id: Int,
    val origin: Int,
    val sender: String,
    val timestamp: Long,
    val content: String
)
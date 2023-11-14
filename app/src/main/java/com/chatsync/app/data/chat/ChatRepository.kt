package com.chatsync.app.data.chat

import com.chatsync.app.domain.chat.ChatConversation
import com.chatsync.app.domain.chat.ChatMessage
import com.chatsync.app.domain.chat.ChatService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ChatRepository @Inject constructor() : ChatService {

    private val _conversations: MutableStateFlow<List<ChatConversation>> =
        MutableStateFlow(listOf())
    override val conversations: StateFlow<List<ChatConversation>> = _conversations.asStateFlow()

    override fun createConversation(
        name: String,
        messages: List<ChatMessage>
    ) {
        _conversations.tryEmit(
            conversations.value.toMutableList().apply {
                add(
                    ChatConversation(
                        id = conversations.value.size,
                        name = name,
                        messages = messages,
                    )
                )
            }
        )
    }
}
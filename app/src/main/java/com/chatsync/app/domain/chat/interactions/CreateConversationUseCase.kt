package com.chatsync.app.domain.chat.interactions

import com.chatsync.app.domain.chat.ChatMessage
import com.chatsync.app.domain.chat.ChatService
import javax.inject.Inject
class CreateConversationUseCase @Inject constructor(
    private val chatService: ChatService
) {
    fun execute(
        name: String,
        messages: List<ChatMessage>
    ) = chatService.createConversation(
        name = name,
        messages = messages
    )
}
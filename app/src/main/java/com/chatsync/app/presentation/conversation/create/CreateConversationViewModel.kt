package com.chatsync.app.presentation.conversation.create

import android.content.ContentResolver
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.chatsync.app.domain.chat.ChatMessage
import com.chatsync.app.domain.chat.ChatOrigin
import com.chatsync.app.domain.chat.facebook_messenger.FacebookMessengerChatConversation
import com.chatsync.app.domain.chat.interactions.CreateConversationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

@HiltViewModel
class CreateConversationViewModel @Inject constructor(
    private val contentResolver: ContentResolver,
    private val createConversationUseCase: CreateConversationUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<CreateConversationUiState> = MutableStateFlow(CreateConversationUiState())
    val uiState: StateFlow<CreateConversationUiState> = _uiState.asStateFlow()

    fun getFacebookMessengerMessages(uri: Uri) {
        try {
            contentResolver.openInputStream(uri)?.let { inputStream ->
                val jsonString = inputStream.bufferedReader().use { it.readText() }
                val jsonParser = Json {
                    ignoreUnknownKeys = true
                }

                val facebookConversation = jsonParser.decodeFromString<FacebookMessengerChatConversation>(jsonString)

                setMessages(
                    messages = facebookConversation.messages.mapIndexed { index, message ->
                        ChatMessage(
                            id = index,
                            origin = ChatOrigin.FacebookMessenger.id,
                            sender = message.sender,
                            timestamp = message.timestamp,
                            content = message.content.orEmpty()
                        )
                    }
                )
            }
        } catch (exception: Exception) {}
    }

    fun setName(text: String) {
        _uiState.tryEmit(
            uiState.value.copy(
                name = text
            )
        )
    }

    fun setMessages(messages: List<ChatMessage>) {
        _uiState.tryEmit(
            uiState.value.copy(
                messages = messages
            )
        )
    }

    fun createConversation(
        name: String,
        messages: List<ChatMessage>
    ) = createConversationUseCase.execute(
        name = name,
        messages = messages
    )
}
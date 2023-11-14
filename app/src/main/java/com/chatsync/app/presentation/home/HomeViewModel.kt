package com.chatsync.app.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chatsync.app.domain.chat.ChatConversation
import com.chatsync.app.domain.chat.ChatService
import com.chatsync.app.domain.settings.Settings
import com.chatsync.app.domain.settings.SettingsService
import com.chatsync.app.domain.settings.interactions.ToggleDarkModeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val settingsService: SettingsService,
    private val chatService: ChatService,
    private val toggleDarkModeUseCase: ToggleDarkModeUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            settingsService.settings.collectLatest { settings: Settings ->
                _uiState.tryEmit(
                    _uiState.value.copy(
                        settings = settings
                    )
                )
            }

            chatService.conversations.collectLatest { conversations: List<ChatConversation> ->
                _uiState.tryEmit(
                    _uiState.value.copy(
                        conversations = conversations
                    )
                )
            }
        }
    }

    fun toggleDarkMode() = toggleDarkModeUseCase.execute()
}
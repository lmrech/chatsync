package com.chatsync.app.presentation.home

import com.chatsync.app.domain.settings.Settings

data class HomeUiState(
    val settings: Settings = Settings()
)
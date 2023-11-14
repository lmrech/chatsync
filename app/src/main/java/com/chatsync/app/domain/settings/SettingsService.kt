package com.chatsync.app.domain.settings

import kotlinx.coroutines.flow.StateFlow

interface SettingsService {
    val settings: StateFlow<Settings>
    fun toggleDarkMode()
}
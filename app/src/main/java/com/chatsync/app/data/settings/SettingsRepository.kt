package com.chatsync.app.data.settings

import com.chatsync.app.domain.settings.Settings
import com.chatsync.app.domain.settings.SettingsService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class SettingsRepository @Inject constructor(): SettingsService {

    private val _settings: MutableStateFlow<Settings> = MutableStateFlow(Settings())
    override val settings: StateFlow<Settings> = _settings.asStateFlow()

    override fun toggleDarkMode() {
        _settings.tryEmit(
            settings.value.copy(
                isDarkMode = !settings.value.isDarkMode
            )
        )
    }
}
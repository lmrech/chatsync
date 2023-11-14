package com.chatsync.app.domain.settings.interactions

import com.chatsync.app.domain.settings.SettingsService
import javax.inject.Inject
class ToggleDarkModeUseCase @Inject constructor(
    private val settingsService: SettingsService
) {
    fun execute() = settingsService.toggleDarkMode()
}
package com.chatsync.app.presentation.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.chatsync.app.domain.settings.Settings
import com.chatsync.app.domain.settings.SettingsService
import com.chatsync.app.presentation.screen.create.addCreateConversationScreenRoute
import com.chatsync.app.presentation.screen.home.addHomeScreenRoute
import com.chatsync.app.presentation.screen.splash.addSplashScreenRoute
import com.chatsync.app.presentation.screen.splash.onSplashDone
import com.chatsync.app.presentation.screen.splash.splashScreenRoute
import com.chatsync.app.presentation.theme.ChatSyncTheme
import com.chatsync.app.presentation.theme.ColorScheme
import com.chatsync.app.presentation.theme.StyleSheet
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class LandingActivity : ComponentActivity() {

    @Inject
    lateinit var settingsService: SettingsService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val settings by settingsService.settings.collectAsStateWithLifecycle()

            LaunchedEffect(
                key1 = settings,
                block = {
                    setStyleSheet(settings)
                }
            )

            ChatSyncTheme(
                darkTheme = settings.isDarkMode,
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            color = StyleSheet.colorScheme.colorPrimary
                        )
                        .imePadding()
                        .systemBarsPadding()
                ) {
                    NavigationRoutes()
                }
            }
        }
    }

    private fun setStyleSheet(settings: Settings) {
        if (settings.isDarkMode) {
            StyleSheet.colorScheme = ColorScheme.Dark

        } else {
            StyleSheet.colorScheme = ColorScheme.Light
        }
    }
}

@Composable
fun NavigationRoutes() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = splashScreenRoute
    ) {
        addSplashScreenRoute(
            onDone = {
                navController.onSplashDone()
            }
        )
        addHomeScreenRoute(navController = navController)
        addCreateConversationScreenRoute(navController = navController)
    }
}
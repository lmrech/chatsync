package com.chatsync.app.presentation.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.chatsync.app.domain.settings.Settings
import com.chatsync.app.domain.settings.SettingsService
import com.chatsync.app.presentation.home.addHomeScreenRoute
import com.chatsync.app.presentation.splash.addSplashScreenRoute
import com.chatsync.app.presentation.splash.onSplashDone
import com.chatsync.app.presentation.splash.splashScreenRoute
import com.chatsync.app.presentation.theme.ChatSyncTheme
import com.chatsync.app.presentation.theme.ColorPalette
import com.chatsync.app.presentation.theme.StyleSheet
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class LandingActivity : ComponentActivity() {

    @Inject
    lateinit var settingsService: SettingsService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, true)

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
                NavigationRoutes()
            }
        }
    }

    private fun setStyleSheet(settings: Settings) {
        if (settings.isDarkMode) {
            StyleSheet.colorPalette = ColorPalette.Dark

        } else {
            StyleSheet.colorPalette = ColorPalette.Light
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
        addHomeScreenRoute()
        addSplashScreenRoute(
            onDone = {
                navController.onSplashDone()
            }
        )
    }
}
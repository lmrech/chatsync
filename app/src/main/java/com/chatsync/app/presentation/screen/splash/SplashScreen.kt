package com.chatsync.app.presentation.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.chatsync.app.presentation.theme.StyleSheet
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onDone: () -> Unit
) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = StyleSheet.colorScheme.colorPrimary
                )
                .padding(paddingValues)
        )

        LaunchedEffect(Unit) {
            delay(1000L)
            onDone()
        }
    }
}
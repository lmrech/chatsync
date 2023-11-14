package com.chatsync.app.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chatsync.app.presentation.theme.StyleSheet


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeUi(
        uiState = uiState,
        toggleDarkMode = viewModel::toggleDarkMode
    )
}

@Composable
fun HomeUi(
    uiState: HomeUiState,
    toggleDarkMode: () -> Unit,
) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = StyleSheet.colorPalette.colorBackground
                )
                .padding(paddingValues)
        ) {
            Text(
                text = "Home",
                color = StyleSheet.colorPalette.colorPrimary,
                style = StyleSheet.textStyle
            )
        }
    }
}
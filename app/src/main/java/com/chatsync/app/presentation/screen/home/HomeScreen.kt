package com.chatsync.app.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.chatsync.app.R
import com.chatsync.app.presentation.screen.create.createConversationScreenRoute
import com.chatsync.app.presentation.theme.StyleSheet

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeUi(
        uiState = uiState,
        onDarkModeClicked = viewModel::toggleDarkMode,
        onFloatingActionButtonClicked = {
            navController.navigate(
                route = createConversationScreenRoute
            )
        }
    )
}

@Composable
fun HomeUi(
    uiState: HomeUiState,
    onDarkModeClicked: () -> Unit,
    onFloatingActionButtonClicked: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                backgroundColor = StyleSheet.colorScheme.colorPrimary,
                contentColor = StyleSheet.colorScheme.colorSecondary
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = StyleSheet.colorScheme.colorBackground
                )
                .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                FloatingActionButton(
                    modifier = Modifier
                        .align(
                            alignment = Alignment.BottomEnd
                        ),
                    backgroundColor = StyleSheet.colorScheme.colorPrimary,
                    onClick = onFloatingActionButtonClicked
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add",
                        tint = StyleSheet.colorScheme.colorSecondary
                    )
                }
            }
        }
    }
}
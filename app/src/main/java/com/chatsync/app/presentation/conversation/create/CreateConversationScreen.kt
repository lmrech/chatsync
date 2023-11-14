package com.chatsync.app.presentation.conversation.create

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.chatsync.app.R
import com.chatsync.app.domain.chat.ChatMessage
import com.chatsync.app.presentation.theme.StyleSheet

@Composable
fun CreateConversationScreen(
    viewModel: CreateConversationViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val facebookMessengerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let {
                viewModel.getFacebookMessengerMessages(uri = it)
            }
        }
    )

    CreateConversationUi(
        uiState = uiState,
        onNavigateUp = {
            navController.navigateUp()
        },
        onNameChanged = viewModel::setName,
        onFacebookMessengerButtonClicked = {
            facebookMessengerLauncher.launch("*/*")
        },
        onCreateButtonClicked = viewModel::createConversation
    )
}

@Composable
fun CreateConversationUi(
    uiState: CreateConversationUiState,
    onNavigateUp: () -> Unit,
    onNameChanged: (String) -> Unit,
    onFacebookMessengerButtonClicked: () -> Unit,
    onCreateButtonClicked: (String, List<ChatMessage>) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                backgroundColor = StyleSheet.colorPalette.colorPrimary,
                contentColor = StyleSheet.colorPalette.colorSecondary,
                navigationIcon = {
                    IconButton(onClick = onNavigateUp) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = StyleSheet.colorPalette.colorSecondary
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = StyleSheet.colorPalette.colorBackground
                )
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = uiState.name,
                        onValueChange = onNameChanged,
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = onFacebookMessengerButtonClicked
                    ) {
                        Text(
                            text = stringResource(id = R.string.import_facebook_messenger),
                            style = StyleSheet.textStyle,
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "${uiState.messages.size} messages imported.",
                        style = StyleSheet.textStyle,
                    )
                }
                
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    enabled = uiState.isCreateButtonEnabled(),
                    onClick = {
                        onCreateButtonClicked(uiState.name, uiState.messages)
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.create),
                        style = StyleSheet.textStyle,
                    )
                }
            }
        }
    }
}
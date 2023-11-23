package com.chatsync.app.presentation.screen.create

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.chatsync.app.presentation.screen.home.slideComposable

const val createConversationScreenRoute = "create_conversation_screen"

fun NavGraphBuilder.addCreateConversationScreenRoute(navController: NavHostController) {
    slideComposable(
        route = createConversationScreenRoute,
    ) {
        CreateConversationScreen(navController = navController)
    }
}
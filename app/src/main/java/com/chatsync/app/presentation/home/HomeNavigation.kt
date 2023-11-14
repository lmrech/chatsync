package com.chatsync.app.presentation.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val homeScreenRoute = "home_screen_route"

fun NavGraphBuilder.addHomeScreenRoute() {
    composable(homeScreenRoute) {
        HomeScreen()
    }
}
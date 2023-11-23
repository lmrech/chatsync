package com.chatsync.app.presentation.screen.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chatsync.app.presentation.screen.home.homeScreenRoute

const val splashScreenRoute = "splash_screen_route"

fun NavGraphBuilder.addSplashScreenRoute(onDone: () -> Unit) {
    composable(splashScreenRoute) {
        SplashScreen(onDone = onDone)
    }
}

fun NavController.onSplashDone() {
    try {
        navigate(
            route = homeScreenRoute,
        ) {
            popUpTo(splashScreenRoute) {
                inclusive = true
            }
        }
    } catch (exception: Exception) {
        exception.printStackTrace()
    }
}
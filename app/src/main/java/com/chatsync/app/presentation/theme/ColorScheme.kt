package com.chatsync.app.presentation.theme

import androidx.compose.ui.graphics.Color

sealed class ColorScheme(
    var colorPrimary: Color,
    var colorSecondary: Color,
    var colorBackground: Color,
) {
   data object Light: ColorScheme(
       colorPrimary = Purple,
       colorSecondary = White,
       colorBackground = White,
   )

    data object Dark: ColorScheme(
        colorPrimary = Purple,
        colorSecondary = White,
        colorBackground = White,
    )
}
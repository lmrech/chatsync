package com.chatsync.app.presentation.theme

import androidx.compose.ui.graphics.Color

sealed class ColorPalette(
    var colorPrimary: Color,
    var colorSecondary: Color,
    var colorBackground: Color,
) {
   data object Light: ColorPalette(
       colorPrimary = Purple,
       colorSecondary = White,
       colorBackground = White,
   )

    data object Dark: ColorPalette(
        colorPrimary = Purple,
        colorSecondary = White,
        colorBackground = White,
    )
}
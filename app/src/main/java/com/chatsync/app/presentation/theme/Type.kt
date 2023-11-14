package com.chatsync.app.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily

sealed class AppTextStyle(
    val regular: TextStyle
) {
    data object SansSerif: AppTextStyle(
        regular = TextStyle(
            fontFamily = FontFamily.SansSerif
        )
    )

    data object Default: AppTextStyle(
        regular = TextStyle(
            fontFamily = FontFamily.Default
        )
    )
}

// Set of Material typography styles to start with
val Typography = Typography(
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
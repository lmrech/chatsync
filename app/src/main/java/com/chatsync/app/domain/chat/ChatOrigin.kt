package com.chatsync.app.domain.chat

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.chatsync.app.R

sealed class ChatOrigin(
    val id: Int,
    val name: String,
    val icon: Int,
    val brush: Brush
) {
    data object FacebookMessenger : ChatOrigin(
        id = FACEBOOK_MESSENGER,
        name = "Facebook Messenger",
        icon = R.drawable.ic_origin_facebook_messenger,
        brush = Brush.verticalGradient(
            colors = listOf(
                Color(0xFF00B2FF),
                Color(0xFF006AFF),
            )
        )
    )

    data object Instagram : ChatOrigin(
        id = INSTAGRAM,
        name = "Instagram",
        icon = R.drawable.ic_origin_instagram,
        brush = Brush.verticalGradient(
            colors = listOf(
                Color(0xFF405DE6),
                Color(0xFF5B51D8),
                Color(0xFF833AB4),
                Color(0xFFC13584),
                Color(0xFFE1306C),
                Color(0xFFF56040),
                Color(0xFFFCAF45),
            )
        )
    )

    data object WhatsApp : ChatOrigin(
        id = WHATSAPP,
        name = "WhatsApp",
        icon = R.drawable.ic_origin_whatsapp,
        brush = Brush.verticalGradient(
            colors = listOf(
                Color(0xFF25D366),
                Color(0xFF075E54),
            )
        )
    )

    companion object {
        const val FACEBOOK_MESSENGER = 0
        const val INSTAGRAM = 1
        const val WHATSAPP = 2
    }
}
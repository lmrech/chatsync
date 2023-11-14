package com.chatsync.app.domain.chat.facebook_messenger

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FacebookMessengerChatMessage(
    @SerialName(value = "sender_name") val sender: String,
    @SerialName(value = "timestamp_ms") val timestamp: Long,
    @SerialName(value = "content") val content: String? = null,
    @SerialName(value = "share") val share: FacebookMessengerChatShare? = null,
    @SerialName(value = "files") val files: List<FacebookMessengerChatFiles>? = null
) {
    @Serializable
    data class FacebookMessengerChatShare(
        @SerialName(value = "link") val link: String,
        @SerialName(value = "share_text") val text: String? = null,
    )

    @Serializable
    data class FacebookMessengerChatFiles(
        @SerialName(value = "uri") val uri: String,
        @SerialName(value = "creation_timestamp") val timestamp: Long,
    )
}
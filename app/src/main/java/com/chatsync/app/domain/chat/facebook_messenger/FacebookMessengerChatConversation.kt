package com.chatsync.app.domain.chat.facebook_messenger

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FacebookMessengerChatConversation(
    @SerialName(value = "participants") val participants: List<FacebookMessengerChatParticipant>,
    @SerialName(value = "messages") val messages: List<FacebookMessengerChatMessage>,
    @SerialName(value = "title") val title: String,
    @SerialName(value = "is_still_participant") val isStillParticipant: Boolean
) {
    @Serializable
    data class FacebookMessengerChatParticipant(
        @SerialName(value = "name") val name: String
    )
}
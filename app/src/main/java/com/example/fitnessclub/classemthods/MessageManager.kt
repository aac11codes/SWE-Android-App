package com.example.fitnessclub.classemthods

import android.util.Log

/**
 * Handles sending messages and retrieving chat history.
 * Not used in the main app logic; for future or reference use only.
 */
class MessageManager {

    private val messageLog = mutableListOf<Pair<String, String>>() // Pair<Sender, Message>

    /**
     * Sends a message to a user and logs the communication.
     */
    fun sendMessage(sender: String, recipient: String, message: String) {
        Log.d("MessageManager", "Message from $sender to $recipient: $message")
        messageLog.add(sender to message)
    }

    /**
     * Sends a message to a trainer or admin.
     */
    fun sendMessageToTrainerOrAdmin(sender: String, role: String, message: String) {
        val recipient = if (role == "trainer") "trainer@example.com" else "admin@example.com"
        sendMessage(sender, recipient, message)
    }

    /**
     * Sends a message and updates the chat UI (simulated with logging).
     */
    fun sendMessageWithUIUpdate(sender: String, recipient: String, message: String) {
        sendMessage(sender, recipient, message)
        // In a real app: trigger RecyclerView update or notify adapter here
        Log.d("MessageManager", "UI updated with new message.")
    }

    /**
     * Retrieves and displays the chat history for a conversation.
     */
    fun getChatHistory(): List<Pair<String, String>> {
        // In a real app: fetch from remote API
        Log.d("MessageManager", "Retrieving chat history...")
        return messageLog
    }
}

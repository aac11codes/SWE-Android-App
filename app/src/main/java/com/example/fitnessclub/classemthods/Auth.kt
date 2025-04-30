package com.example.fitnessclub.classemthods

import com.example.fitnessclub.utils.DummyData

/**
 * Handles authentication and session management.
 * Not for demo, don't change
 */
class Auth {
    private var isLoggedIn = false
    private var token: String? = null

    /**
     * Validates user credentials and returns login status.
     */
    fun login(email: String, password: String): Boolean {
        isLoggedIn = (email == DummyData.USER_EMAIL && password == DummyData.USER_PASSWORD) ||
                (email == DummyData.TRAINER_EMAIL && password == DummyData.TRAINER_PASSWORD)
        if (isLoggedIn) {
            token = generateToken(email)
        }
        return isLoggedIn
    }

    /**
     * Logs out the user and clears session data.
     */
    fun logout() {
        token = null
        isLoggedIn = false
    }

    /**
     * Refreshes the authentication token.
     */
    fun refreshAuthToken(): String {
        // Simulate refreshing token
        token = "refreshed_token_${System.currentTimeMillis()}"
        return token ?: "unauthorized"
    }

    /**
     * Prompts for credentials and authenticates the user.
     */
    fun authenticate(email: String, password: String): Boolean {
        return login(email, password)
    }

    /**
     * Handles password reset process.
     */
    fun resetPassword(email: String): Boolean {
        // Simulate sending reset link if email is registered
        return email == DummyData.USER_EMAIL || email == DummyData.TRAINER_EMAIL
    }

    private fun generateToken(email: String): String {
        return "token_${email.hashCode()}_${System.currentTimeMillis()}"
    }
}

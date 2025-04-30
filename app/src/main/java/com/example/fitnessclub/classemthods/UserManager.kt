package com.example.fitnessclub.classemthods

import android.util.Log
import com.example.fitnessclub.models.Workout
import com.example.fitnessclub.utils.DummyData

/**
 * Handles user and trainer management, as well as complaints.
 */
class UserManager {

    data class User(
        val id: Int,
        val email: String,
        var age: Int,
        var weight: Float,
        var height: Float,
        var fitnessLevel: String
    )

    data class Complaint(val email: String, val content: String)

    // Simulated user database
    private val users = mutableListOf(
        User(1, DummyData.USER_EMAIL, 25, 62.5f, 170f, "Beginner"),
        User(2, DummyData.TRAINER_EMAIL, 30, 70.0f, 180f, "Intermediate")
    )

    private val complaints = mutableListOf<Complaint>()

    /**
     * Prompts the user to update their fitness information.
     */
    fun updateFitnessInfo(email: String, age: Int, weight: Float, height: Float, level: String): Boolean {
        val user = users.find { it.email == email }
        return if (user != null) {
            user.age = age
            user.weight = weight
            user.height = height
            user.fitnessLevel = level
            Log.d("UserManager", "Updated info for $email")
            true
        } else {
            Log.d("UserManager", "User not found: $email")
            false
        }
    }

    /**
     * Returns a list of all registered users.
     */
    fun getAllUsers(): List<String> {
        return users.map {
            "${it.email} - Age: ${it.age}, Fitness: ${it.fitnessLevel}"
        }
    }

    /**
     * Deletes a user from the system (demo only).
     */
    fun deleteUser(email: String): Boolean {
        val removed = users.removeIf { it.email == email }
        if (removed) {
            Log.d("UserManager", "Deleted user: $email")
        } else {
            Log.d("UserManager", "User not found for deletion: $email")
        }
        return removed
    }

    /**
     * Assigns workouts to a user based on their fitness level.
     */
    fun assignWorkoutsToUser(email: String): List<Workout> {
        val user = users.find { it.email == email } ?: return emptyList()
        val workouts = DummyData.userWorkouts.filter {
            it.fitnessLevel.equals(user.fitnessLevel, ignoreCase = true)
        }
        Log.d("UserManager", "Assigned ${workouts.size} workouts to $email")
        return workouts
    }

    /**
     * Handles user complaints.
     */
    fun handleComplaints(): List<String> {
        if (complaints.isEmpty()) {
            Log.d("UserManager", "No complaints available.")
            return listOf("No complaints submitted.")
        }
        return complaints.map { "From ${it.email}: ${it.content}" }
    }

    /**
     * Adds a complaint to the system.
     */
    fun addComplaint(email: String, message: String) {
        complaints.add(Complaint(email, message))
        Log.d("UserManager", "Complaint added from $email")
    }

    /**
     * Simulates trainer performance summary.
     */
    fun reviewTrainerPerformance(): String {
        // hardcoded ratings from DummyData
        return "Trainer Performance:\n- Coach Tom: 4.8★\n- Trainer Jane: 4.6★"
    }
}

package com.example.fitnessclub.utils

import com.example.fitnessclub.models.Workout

object DummyData {
    // Demo users
    const val USER_EMAIL = "user@example.com"
    const val USER_PASSWORD = "password"
    const val TRAINER_EMAIL = "trainer@example.com"
    const val TRAINER_PASSWORD = "password"

    // Sample workouts
    val userWorkouts = listOf(
        Workout(1, "Morning Cardio", "30 minutes of cardio exercises", "30 min", "Beginner"),
        Workout(2, "Strength Training", "Full body strength workout", "45 min", "Intermediate"),
        Workout(3, "Yoga Session", "Relaxing yoga routine", "60 min", "Beginner")
    )

    val trainerWorkouts = listOf(
        Workout(1, "Client A: Cardio", "High-intensity cardio session", "45 min", "Advanced"),
        Workout(2, "Client B: Strength", "Upper body strength training", "60 min", "Intermediate"),
        Workout(3, "Client C: Yoga", "Beginner yoga session", "45 min", "Beginner")
    )

    // Sample chat messages
    val chatMessages = listOf(
        "Hello! How can I help you today?",
        "I'd like to know more about my workout plan.",
        "Sure! Your current plan focuses on building strength and endurance.",
        "When should I do my cardio exercises?",
        "I recommend doing cardio in the morning before breakfast."
    )

    // Fitness goals
    val fitnessGoals = listOf(
        "Weight Loss",
        "Muscle Gain",
        "Endurance",
        "Flexibility",
        "General Fitness"
    )

    // Fitness levels
    val fitnessLevels = listOf(
        "Beginner",
        "Intermediate",
        "Advanced"
    )

    // Available workout times
    val workoutTimes = listOf(
        "30 minutes",
        "45 minutes",
        "60 minutes",
        "90 minutes",
        "120 minutes"
    )
} 
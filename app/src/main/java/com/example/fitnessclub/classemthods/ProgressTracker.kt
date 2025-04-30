package com.example.fitnessclub.classemthods

import android.util.Log

/**
 * Handles tracking and summarizing user fitness progress.
 */
class ProgressTracker {

    data class ProgressEntry(
        val workoutId: Int,
        val caloriesBurned: Int,
        val weightChangeKg: Float,
        val notes: String
    )

    private val progressLog = mutableListOf<ProgressEntry>()

    /**
     * Tracks user progress and provides feedback.
     */
    fun trackProgress(): String {
        if (progressLog.isEmpty()) {
            return "No progress data available."
        }

        val avgCalories = progressLog.map { it.caloriesBurned }.average()
        val totalWeightChange = progressLog.sumOf { it.weightChangeKg }

        return "Avg calories burned: ${avgCalories.toInt()} kcal\n" +
                "Total weight change: ${"%.1f".format(totalWeightChange)} kg"
    }

    /**
     * Logs a workout session's progress details.
     */
    fun logProgress(workoutId: Int, caloriesBurned: Int, weightChangeKg: Float, notes: String) {
        val entry = ProgressEntry(workoutId, caloriesBurned, weightChangeKg, notes)
        progressLog.add(entry)
        Log.d("ProgressTracker", "Progress logged: $entry")
    }

    /**
     * Returns a summary of the user's progress as a formatted string.
     */
    fun getProgressSummary(): String {
        return buildString {
            appendLine("=== Progress Summary ===")
            progressLog.forEachIndexed { index, entry ->
                appendLine("Session ${index + 1}:")
                appendLine("Workout ID: ${entry.workoutId}")
                appendLine("Calories Burned: ${entry.caloriesBurned}")
                appendLine("Weight Change: ${entry.weightChangeKg} kg")
                appendLine("Notes: ${entry.notes}")
                appendLine("------------------------")
            }
            appendLine(trackProgress())
        }
    }

    /**
     * Displays the user's progress details.
     */
    fun viewProgress() {
        Log.d("ProgressTracker", getProgressSummary())
    }
}

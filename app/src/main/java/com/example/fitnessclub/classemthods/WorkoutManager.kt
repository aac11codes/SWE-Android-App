package com.example.fitnessclub.classemthods

import android.util.Log
import com.example.fitnessclub.models.Workout
import com.example.fitnessclub.utils.DummyData

/**
 * Handles creation, updating, completion, and cancellation of workout plans.
 * Partially integrated with real app logic via DummyData and Workout model.
 */
class WorkoutManager {

    private val activeWorkouts = mutableListOf<Workout>()
    private val completedWorkouts = mutableListOf<Workout>()
    private val availablePlans = DummyData.userWorkouts + DummyData.trainerWorkouts

    /**
     * Creates a workout plan for a user based on their goals and fitness level.
     */
    fun createWorkoutPlan(goal: String, level: String): List<Workout> {
        val plan = availablePlans.filter {
            it.description.contains(goal, ignoreCase = true) ||
                    it.fitnessLevel.equals(level, ignoreCase = true)
        }
        activeWorkouts.addAll(plan)
        Log.d("WorkoutManager", "Created plan with ${plan.size} workouts for goal: $goal, level: $level")
        return plan
    }

    /**
     * Updates an existing workout plan (exercises, duration, schedule).
     */
    fun updateWorkout(workoutId: Int, newTitle: String, newDuration: String) {
        val workout = activeWorkouts.find { it.id == workoutId }
        workout?.let {
            it.name = newTitle
            it.duration = newDuration
            Log.d("WorkoutManager", "Updated workout $workoutId to $newTitle / $newDuration")
        } ?: Log.d("WorkoutManager", "Workout not found: $workoutId")
    }

    /**
     * Marks a workout as completed and adds it to the user's progress history.
     */
    fun completeWorkout(workoutId: Int) {
        val workout = activeWorkouts.find { it.id == workoutId }
        workout?.let {
            completedWorkouts.add(it)
            activeWorkouts.remove(it)
            Log.d("WorkoutManager", "Completed workout: ${it.name}")
        } ?: Log.d("WorkoutManager", "Workout not found: $workoutId")
    }

    /**
     * Cancels a workout, removes it from the schedule, and notifies relevant parties.
     */
    fun cancelWorkout(workoutId: Int) {
        val removed = activeWorkouts.removeIf { it.id == workoutId }
        if (removed) {
            Log.d("WorkoutManager", "Workout $workoutId cancelled.")
        } else {
            Log.d("WorkoutManager", "Workout not found: $workoutId")
        }
    }

    /**
     * Creates a new workout and assigns it to a user.
     */
    fun createWorkout(name: String, description: String, duration: String, level: String): Workout {
        val newWorkout = Workout(
            id = (activeWorkouts.maxOfOrNull { it.id } ?: 0) + 1,
            name = name,
            description = description,
            duration = duration,
            fitnessLevel = level
        )
        activeWorkouts.add(newWorkout)
        Log.d("WorkoutManager", "New workout created: $name")
        return newWorkout
    }

    /**
     * Deletes a workout from the active workouts list.
     */
    fun deleteWorkout(workoutId: Int): Boolean {
        val removed = activeWorkouts.removeIf { it.id == workoutId }
        Log.d("WorkoutManager", if (removed) "Workout $workoutId deleted." else "Workout not found.")
        return removed
    }

    /**
     * Displays the assigned workout plan for a user.
     */
    fun displayPlan(): List<String> {
        return activeWorkouts.map {
            "Workout: ${it.name} | Duration: ${it.duration} | Level: ${it.fitnessLevel}"
        }
    }

    /**
     * Allows a trainer to modify a user's workout plan.
     */
    fun modifyPlan(workoutId: Int, newDescription: String) {
        val workout = activeWorkouts.find { it.id == workoutId }
        workout?.let {
            it.description = newDescription
            Log.d("WorkoutManager", "Modified workout $workoutId: $newDescription")
        } ?: Log.d("WorkoutManager", "Workout not found: $workoutId")
    }

    /**
     * Lets a user browse and join available workout plans.
     */
    fun joinWorkoutPlan(planKeyword: String): List<Workout> {
        val joined = availablePlans.filter {
            it.name.contains(planKeyword, ignoreCase = true) ||
                    it.description.contains(planKeyword, ignoreCase = true)
        }
        activeWorkouts.addAll(joined)
        Log.d("WorkoutManager", "Joined ${joined.size} workouts with keyword: $planKeyword")
        return joined
    }

    // For inspection/debugging purposes
    fun getActiveWorkouts(): List<Workout> = activeWorkouts
    fun getCompletedWorkouts(): List<Workout> = completedWorkouts
}

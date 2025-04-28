package com.example.fitnessclub.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessclub.R
import com.example.fitnessclub.models.Workout

class WorkoutAdapter(private val workouts: List<Workout>) :
    RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>() {

    class WorkoutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.workoutNameTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.workoutDescriptionTextView)
        val durationTextView: TextView = itemView.findViewById(R.id.workoutDurationTextView)
        val difficultyTextView: TextView = itemView.findViewById(R.id.workoutDifficultyTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_workout, parent, false)
        return WorkoutViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val workout = workouts[position]
        holder.nameTextView.text = workout.name
        holder.descriptionTextView.text = workout.description
        holder.durationTextView.text = workout.duration
        holder.difficultyTextView.text = workout.difficulty
    }

    override fun getItemCount() = workouts.size
} 
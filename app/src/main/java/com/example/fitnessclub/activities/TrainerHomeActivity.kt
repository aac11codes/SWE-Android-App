package com.example.fitnessclub.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessclub.databinding.ActivityTrainerHomeBinding
import com.example.fitnessclub.utils.DummyData

class TrainerHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTrainerHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrainerHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(com.example.fitnessclub.R.string.trainer_home_title)

        setupWorkoutList()
        setupChatButton()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupWorkoutList() {
        binding.workoutsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.workoutsRecyclerView.adapter = WorkoutAdapter(DummyData.trainerWorkouts)
    }

    private fun setupChatButton() {
        binding.chatButton.setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
        }
    }
} 
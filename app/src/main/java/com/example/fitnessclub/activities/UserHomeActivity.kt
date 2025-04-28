package com.example.fitnessclub.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessclub.databinding.ActivityUserHomeBinding
import com.example.fitnessclub.utils.DummyData

class UserHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(com.example.fitnessclub.R.string.user_home_title)

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
        binding.workoutsRecyclerView.adapter = WorkoutAdapter(DummyData.userWorkouts)
    }

    private fun setupChatButton() {
        binding.chatButton.setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
        }
    }
} 
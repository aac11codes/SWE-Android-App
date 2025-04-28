package com.example.fitnessclub.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessclub.databinding.ActivityQuestionnaireBinding
import com.example.fitnessclub.utils.DummyData

class QuestionnaireActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionnaireBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionnaireBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(com.example.fitnessclub.R.string.questionnaire_title)

        setupDropdowns()
        setupButtons()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupDropdowns() {
        // Setup fitness goals dropdown
        val fitnessGoalAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            DummyData.fitnessGoals
        )
        binding.fitnessGoalDropdown.setAdapter(fitnessGoalAdapter)

        // Setup fitness level dropdown
        val fitnessLevelAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            DummyData.fitnessLevels
        )
        binding.fitnessLevelDropdown.setAdapter(fitnessLevelAdapter)

        // Setup workout time dropdown
        val workoutTimeAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            DummyData.workoutTimes
        )
        binding.workoutTimeDropdown.setAdapter(workoutTimeAdapter)
    }

    private fun setupButtons() {
        binding.submitButton.setOnClickListener {
            // In a real app, we would save the questionnaire data here
            navigateToHomeScreen()
        }

        binding.skipButton.setOnClickListener {
            navigateToHomeScreen()
        }
    }

    private fun navigateToHomeScreen() {
        val intent = Intent(this, UserHomeActivity::class.java)
        startActivity(intent)
        finish()
    }
} 
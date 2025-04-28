package com.example.fitnessclub.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessclub.databinding.ActivityLoginBinding
import com.example.fitnessclub.utils.DummyData

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (validateCredentials(email, password)) {
                binding.errorTextView.visibility = View.GONE
                navigateToNextScreen(email)
            } else {
                binding.errorTextView.visibility = View.VISIBLE
                binding.errorTextView.text = getString(com.example.fitnessclub.R.string.login_error)
            }
        }
    }

    private fun validateCredentials(email: String, password: String): Boolean {
        return (email == DummyData.USER_EMAIL && password == DummyData.USER_PASSWORD) ||
                (email == DummyData.TRAINER_EMAIL && password == DummyData.TRAINER_PASSWORD)
    }

    private fun navigateToNextScreen(email: String) {
        val intent = when (email) {
            DummyData.USER_EMAIL -> Intent(this, QuestionnaireActivity::class.java)
            DummyData.TRAINER_EMAIL -> Intent(this, TrainerHomeActivity::class.java)
            else -> return
        }
        startActivity(intent)
        finish()
    }
} 
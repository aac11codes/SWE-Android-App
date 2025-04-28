package com.example.fitnessclub.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessclub.databinding.ActivityChatBinding
import com.example.fitnessclub.utils.DummyData

class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding
    private val messages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(com.example.fitnessclub.R.string.chat_title)

        setupChatList()
        setupSendButton()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupChatList() {
        messages.addAll(DummyData.chatMessages)
        binding.messagesRecyclerView.layoutManager = LinearLayoutManager(this).apply {
            stackFromEnd = true
        }
        binding.messagesRecyclerView.adapter = ChatAdapter(messages)
        binding.messagesRecyclerView.scrollToPosition(messages.size - 1)
    }

    private fun setupSendButton() {
        binding.sendButton.setOnClickListener {
            val message = binding.messageEditText.text.toString().trim()
            if (message.isNotEmpty()) {
                messages.add(message)
                binding.messagesRecyclerView.adapter?.notifyItemInserted(messages.size - 1)
                binding.messagesRecyclerView.scrollToPosition(messages.size - 1)
                binding.messageEditText.text.clear()
            }
        }
    }
} 
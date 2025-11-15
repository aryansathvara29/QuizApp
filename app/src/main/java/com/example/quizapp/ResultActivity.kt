package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        val tvScore = findViewById<TextView>(R.id.tvScore)
        val btnDone = findViewById<Button>(R.id.btnDone)

        tvScore.text = "Your score: $score / $total"

        btnDone.setOnClickListener {
            // Go back to quiz list
            val intent = Intent(this, QuizListActivity::class.java)
            // Clear back stack
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}

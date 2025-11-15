package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // If you have a button on main screen to start quiz list
        val btnStartQuiz = findViewById<Button>(R.id.btnStartQuiz)

        btnStartQuiz.setOnClickListener {
            startActivity(Intent(this, QuizListActivity::class.java))
        }
    }
}

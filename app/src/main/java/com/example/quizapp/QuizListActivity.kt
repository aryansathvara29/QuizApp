package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.data.QuestionData

class QuizListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_list)

        val rv = findViewById<RecyclerView>(R.id.rvQuizzes)
        rv.layoutManager = LinearLayoutManager(this)
        val quizzes = QuestionData.quizList // list of QuizItem
        val adapter = QuizListAdapter(quizzes) { quizId ->
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra("quizId", quizId)
            startActivity(intent)
        }
        rv.adapter = adapter
    }
}

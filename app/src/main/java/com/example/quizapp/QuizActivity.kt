package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.data.Question
import com.example.quizapp.data.QuestionData

class QuizActivity : AppCompatActivity() {

    private var currentIndex = 0
    private var score = 0
    private lateinit var questions: List<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val quizId = intent.getIntExtra("quizId", 0)
        questions = QuestionData.getById(quizId).questions

        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val rgOptions = findViewById<RadioGroup>(R.id.rgOptions)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val tvQNumber = findViewById<TextView>(R.id.tvQNumber)

        fun showQuestion() {
            val q = questions[currentIndex]
            tvQuestion.text = q.question
            tvQNumber.text = "Question ${currentIndex + 1} / ${questions.size}"
            rgOptions.removeAllViews()
            q.options.forEachIndexed { idx, opt ->
                val rb = RadioButton(this)
                rb.id = idx
                rb.text = opt
                rgOptions.addView(rb)
            }
        }

        showQuestion()

        btnNext.setOnClickListener {
            val selectedId = rgOptions.checkedRadioButtonId
            if (selectedId != -1) {
                val q = questions[currentIndex]
                if (selectedId == q.answerIndex) score++
            }
            if (currentIndex < questions.size - 1) {
                currentIndex++
                rgOptions.clearCheck()
                showQuestion()
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }
}

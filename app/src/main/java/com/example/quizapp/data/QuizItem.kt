package com.example.quizapp.data

data class QuizItem(
    val id: Int,
    val title: String,
    val description: String,
    val questions: List<Question>
)

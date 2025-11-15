package com.example.quizapp.data

object QuestionData {

    private val quiz1Questions = listOf(
        Question("What is 2 + 2?", listOf("1", "2", "3", "4"), 3),
        Question("Capital of France?", listOf("Berlin", "Paris", "Rome", "Madrid"), 1),
        Question("Which planet is red?", listOf("Earth", "Venus", "Mars", "Jupiter"), 2)
    )

    private val quiz2Questions = listOf(
        Question("Who discovered gravity?", listOf("Newton", "Edison", "Tesla", "Bohr"), 0),
        Question("H2O is chemical for?", listOf("Salt", "Water", "Oxygen", "Hydrogen"), 1)
    )

    val quizList = listOf(
        QuizItem(1, "General Knowledge", "Short GK quiz", quiz1Questions),
        QuizItem(2, "Science Basics", "Simple science questions", quiz2Questions)
    )

    fun getById(id: Int): QuizItem {
        return quizList.firstOrNull { it.id == id } ?: quizList[0]
    }
}

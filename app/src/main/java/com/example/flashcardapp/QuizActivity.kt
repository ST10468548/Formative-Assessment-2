package com.example.flashcardapp

import android.content.Intent
import android.widget.*
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994",
        "World War II ended in 1942",
        "The Berlin Wall fell in 1989",
        "The Great Depression began in 1929",
        "Julius Caesar was a Roman Emperor"
    )
    private val answers = arrayOf(true, false, true, true, false)
    private var currentQuestion = 0
    private var score = 0

    private lateinit var txtQuestion: TextView
    private lateinit var txtFeedback: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        txtQuestion = findViewById(R.id.questionText)
        txtFeedback = findViewById(R.id.feedbackText)
        btnTrue = findViewById(R.id.trueButton)
        btnFalse = findViewById(R.id.falseButton)
        btnNext = findViewById(R.id.nextButton)

        displayQuestion()

        btnTrue.setOnClickListener { checkAnswer(true) }
        btnFalse.setOnClickListener { checkAnswer(false) }
        btnNext.setOnClickListener {
            currentQuestion++
            if (currentQuestion < questions.size) {
                displayQuestion()
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("questions", questions)
                intent.putExtra("answers", answers)
                startActivity(intent)
            }
        }
    }

    private fun displayQuestion() {
        txtQuestion.text = questions[currentQuestion]
        txtFeedback.text = ""
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestion]
        if (userAnswer == correctAnswer) {
            txtFeedback.text = "Correct!"
            score++
        } else {
            txtFeedback.text = "Incorrect"
        }
    }
}

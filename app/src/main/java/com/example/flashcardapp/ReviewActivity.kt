package com.example.flashcardapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val reviewText = findViewById<TextView>(R.id.reviewText)
        val questions = arrayOf(
            "Nelson Mandela was president in 1994. ➤ True",
            "The Berlin Wall fell in 1990. ➤ False",
            "Julius Caesar was a Roman emperor. ➤ False",
            "The Great Fire of London happened in 1666. ➤ True",
            "World War II ended in 1945. ➤ True"
        )
        reviewText.text = questions.joinToString("\n\n")
    }
}
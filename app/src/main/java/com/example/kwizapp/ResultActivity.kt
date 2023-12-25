package com.example.kwizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var scoreIntent = intent
        var displayScore = scoreIntent.getIntExtra("Score",0)

        var resultScore:TextView = findViewById(R.id.resultScore)
        var redo:Button = findViewById(R.id.redo)
        var quit:Button = findViewById(R.id.quit)

        resultScore.text = "You have scored $displayScore marks"

        redo.setOnClickListener {
            Intent(this@ResultActivity,DifficultyLevel::class.java).also{
                startActivity(it)
                finish()
            }

        }

        quit.setOnClickListener {
           finish()
        }


    }
}
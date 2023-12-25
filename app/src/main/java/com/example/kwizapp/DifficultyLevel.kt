package com.example.kwizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView

class DifficultyLevel : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.difficulty_level)

        var intent = intent
        var intentName = intent.getStringExtra("Key")

        var difficultyDisplayName:TextView = findViewById(R.id.difficultyDisplayName)
        var normalCard:CardView = findViewById(R.id.normalCard)
        var intermediateCard:CardView = findViewById(R.id.intermediateCard)
        var hardCard:CardView = findViewById(R.id.hardCard)

        if(!intentName.isNullOrEmpty()) {
            difficultyDisplayName.text = "Hi ${intentName}!"
        }

        normalCard.setOnClickListener{
            Toast.makeText(this@DifficultyLevel,"Normal Mode",Toast.LENGTH_SHORT).show()

            Intent(this@DifficultyLevel, QuestionsActivity::class.java).putExtra("Mode",1).also{
                startActivity(it)
                finish()

            }
        }

        intermediateCard.setOnClickListener{
            Toast.makeText(this@DifficultyLevel,"Intermediate Mode",Toast.LENGTH_SHORT).show()
            Intent(this@DifficultyLevel,QuestionsActivity::class.java).putExtra("Mode",2).also {
                startActivity(it)
                finish()
            }
        }

        hardCard.setOnClickListener{
            Toast.makeText(this@DifficultyLevel,"Hard Mode",Toast.LENGTH_SHORT).show()
            Intent(this@DifficultyLevel,QuestionsActivity::class.java).putExtra("Mode",3).also{
                startActivity(it)
                finish()
            }
        }
    }
}
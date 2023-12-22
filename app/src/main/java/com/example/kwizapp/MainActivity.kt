package com.example.kwizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nameEditText:EditText = findViewById(R.id.nameEditText)
        var startButton:Button = findViewById(R.id.startButton)

        startButton.setOnClickListener {

            if (nameEditText.text.isEmpty())
            {
                Toast.makeText(this@MainActivity,"Please enter Name",Toast.LENGTH_SHORT).show()
            }
            else
            {
                Intent(this@MainActivity, DifficultyLevel::class.java).also {
                    startActivity(it)
                }
                finish()
            }
        }


    }
}
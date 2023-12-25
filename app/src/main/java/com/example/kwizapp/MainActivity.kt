package com.example.kwizapp

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nameEditText:EditText = findViewById(R.id.nameEditText)
        nameEditText.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS)//To get first letter as capital from keyboard

        var startButton:Button = findViewById(R.id.startButton)

        startButton.setOnClickListener {

            if (nameEditText.text.isEmpty())
            {
                Toast.makeText(this@MainActivity,"Please enter Name",Toast.LENGTH_SHORT).show()
            }
            else
            {
                Intent(this@MainActivity, DifficultyLevel::class.java).putExtra("Key",nameEditText.text.toString()).also {//PutExtra is used to pass editText from one activity to another
                    startActivity(it)

                }
                finish()
            }
        }


    }
}
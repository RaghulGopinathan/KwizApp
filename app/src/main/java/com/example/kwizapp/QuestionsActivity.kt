package com.example.kwizapp

import android.content.Intent
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuestionsActivity : AppCompatActivity() {

    lateinit var question:TextView
    lateinit var image:ImageView
    lateinit var option1: TextView
    lateinit var option2: TextView
    lateinit var progress:ProgressBar
    lateinit var progressText:TextView
    lateinit var nextQuestion:Button

    var counter = 0
    var selectedOption = 0
    var score = 0

    var initialCallFlag = 1
    var previousQuestion = -1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        question = findViewById(R.id.question)
        image = findViewById(R.id.image)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        progress = findViewById(R.id.progressBar)
        progressText = findViewById(R.id.progressText)
        nextQuestion = findViewById(R.id.nextQuestion)


        setQuestion()

        option1.setOnClickListener{
            resetOptionStyle()
            option1.setBackgroundResource(R.drawable.scratch)
            option1.setTextColor(Color.WHITE)
            selectedOption = 1
        }

        option2.setOnClickListener{
            resetOptionStyle()
            option2.setBackgroundResource(R.drawable.scratch)
            option2.setTextColor(Color.WHITE)
            selectedOption = 2
        }


        nextQuestion.setOnClickListener {
                previousQuestion++
                counter++
                setQuestion()
                resetOptionStyle()


        }



    }



    fun setQuestion()
    {


        var mlist:MutableList<QuestionRequirements> = questionClass.questionList()


        if(previousQuestion>=0)
        {
            var ans = mlist[previousQuestion].answers
            println("Question $previousQuestion answer is $ans")
        }

        if(counter<mlist.size) {
            var questionNo: QuestionRequirements = mlist[counter]
            question.text = "Q${counter+1}: ${questionNo.question}"
            image.setImageResource(questionNo.image)
            option1.text = questionNo.option1
            option2.text = questionNo.option2
            progress.max = mlist.size
            progress.setProgress(counter+1)
            progressText.text = "${counter+1}/${mlist.size}"

            if(counter==mlist.size-1)
            {
                nextQuestion.text = "Finish"
            }
        }
        else
        {
            Intent(this@QuestionsActivity,ResultActivity::class.java).also{
                startActivity(it)
            }
        }






    }
    
    fun resetOptionStyle()
    {
        option1.setTextColor(Color.BLACK)
        option2.setTextColor(Color.BLACK)
        option1.setBackgroundResource(R.drawable.options_border)
        option2.setBackgroundResource(R.drawable.options_border)
    }

    fun previousQuestionAnswer()
    {

    }
}

data class QuestionRequirements(var id:Int,var question:String,var image:Int,var option1:String,var option2:String,var answers:Int)

object questionClass{

    fun questionList():MutableList<QuestionRequirements>
    {
        var temp = mutableListOf<QuestionRequirements>()
        var question1 = QuestionRequirements(1,"What is the name of this animal?",R.drawable.whale,"Whale","Crocodile",1)
        temp.add(question1)

        var question2 = QuestionRequirements(2,"What is the color of this bear?",R.drawable.bear,"Brown","White",1)
        temp.add(question2)

        var question3 = QuestionRequirements(3,"Is this animal a cat?",R.drawable.dog,"Yes","No",1)
        temp.add(question3)
        return temp
    }

}
package com.example.timelylemon

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.timelylemon.databinding.ActivityLandingBinding
import com.example.timelylemon.databinding.ActivityQuestionsBinding
import com.example.timelylemon.models.Constants
import com.example.timelylemon.models.Constants.getAll70sQuestions
import com.example.timelylemon.models.Constants.getAll80sQuestions
import com.example.timelylemon.models.Constants.getAll90sQuestions
import com.example.timelylemon.models.Question
import com.google.android.material.radiobutton.MaterialRadioButton


class QuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //full screen
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding.qpQuestion.setMovementMethod(ScrollingMovementMethod())

        supportActionBar?.hide()

        val username = intent.getStringExtra("username")
        var questionNumber = intent.getIntExtra("questionNumber", 0)
        var score = intent.getIntExtra("Score", 0)
        val currentTrivia = intent.getIntExtra("TriviaNumber", 1);
        Log.i("Trivia Number", currentTrivia.toString())

        var questions = getAll70sQuestions()

        //set current category
        if(currentTrivia == 1){
            questions = getAll70sQuestions()
        } else if(currentTrivia == 2){
            questions = getAll80sQuestions()
        } else if(currentTrivia == 3){
            questions = getAll90sQuestions()
        }

        val currentQuestion = questions[questionNumber]

        updateUi(currentQuestion)

        binding.btnBack.setOnClickListener {
            val backButton = Intent(this, LandingActivity::class.java)
            startActivity(backButton)
            finish()
        }

        binding.btnNext.setOnClickListener {
            var selectedAnswer = binding.rgAnswers.checkedRadioButtonId

            if (selectedAnswer == -1) {
                val toast = Toast.makeText(this, "please select an answer", Toast.LENGTH_SHORT)
                toast.show()
            } else {
                var userAnswer = findViewById<MaterialRadioButton>(selectedAnswer) //find checkbox that has been selected
                Log.i("Selected Answer: ", userAnswer.text.toString())

                //set current category
                if(currentTrivia == 1){
                    //check Category One Answers correct
                    if (userAnswer.text.toString() == questions[0].optionFour) {
                        score += 50
                        userAnswer.setBackgroundResource(R.drawable.img_cat_sev_correct)
                    } else if (userAnswer.text.toString() == questions[1].optionTwo){
                        score += 50
                        userAnswer.setBackgroundResource(R.drawable.img_cat_sev_correct)
                    } else if (userAnswer.text.toString() == questions[2].optionTwo){
                        score += 50
                        userAnswer.setBackgroundResource(R.drawable.img_cat_sev_correct)
                    } else if (userAnswer.text.toString() == questions[3].optionOne){
                        score += 50
                        userAnswer.setBackgroundResource(R.drawable.img_cat_sev_correct)
                    } else if (userAnswer.text.toString() == questions[4].optionThree){
                        score += 50
                        userAnswer.setBackgroundResource(R.drawable.img_cat_sev_correct)
                    }
                } else if(currentTrivia == 2){
                    //check Category Two Answers correct
                    if (userAnswer.text.toString() == questions[0].optionThree) {
                        score += 50
                        userAnswer.setBackgroundResource(R.drawable.img_cat_eight_correct)
                    } else if (userAnswer.text.toString() == questions[1].optionTwo){
                        score += 50
                        userAnswer.setBackgroundResource(R.drawable.img_cat_eight_correct)
                    } else if (userAnswer.text.toString() == questions[2].optionTwo){
                        score += 50
                        userAnswer.setBackgroundResource(R.drawable.img_cat_eight_correct)
                    } else if (userAnswer.text.toString() == questions[3].optionOne){
                        score += 50
                        userAnswer.setBackgroundResource(R.drawable.img_cat_eight_correct)
                    } else if (userAnswer.text.toString() == questions[4].optionFour){
                        score += 50
                        userAnswer.setBackgroundResource(R.drawable.img_cat_eight_correct)
                    }
                } else if(currentTrivia == 3){
                    //check Category Three Answers correct
                    if (userAnswer.text.toString() == questions[0].optionTwo) {
                        score += 50
                        userAnswer.setBackgroundResource(R.drawable.img_cat_nine_correct)
                    } else if (userAnswer.text.toString() == questions[1].optionThree){
                        score += 50
                        userAnswer.setBackgroundResource(R.drawable.img_cat_nine_correct)
                    } else if (userAnswer.text.toString() == questions[2].optionOne){
                        score += 50
                        userAnswer.setBackgroundResource(R.drawable.img_cat_nine_correct)
                    } else if (userAnswer.text.toString() == questions[3].optionOne){
                        score += 50
                        userAnswer.setBackgroundResource(R.drawable.img_cat_nine_correct)
                    } else if (userAnswer.text.toString() == questions[4].optionFour){
                        score += 50
                        userAnswer.setBackgroundResource(R.drawable.img_cat_nine_correct)
                    }
                }

                //check if done
                if (questionNumber + 1 == questions.count()) {
                    //if true
                    //Navigate to results
                    val intent = Intent(this, ResultsActivity::class.java)
                    val count = questions.count()
                    Log.i("Number of Questions:", count.toString())
                    intent.putExtra("Score", score)
                    intent.putExtra("QuestionNum", currentTrivia)
                    Log.i("current Cat", currentTrivia.toString())
                    intent.putExtra("username", username)

                    startActivity(intent)
                    finish()
                } else {
                    val intent = Intent(this, QuestionsActivity::class.java)
                    //pass username and next question
                    intent.putExtra("username", username)
                    intent.putExtra("QuestionNum", currentTrivia)
                    intent.putExtra("questionNumber", questionNumber + 1)
                    //pass more values
                    intent.putExtra("Score", score)
                    intent.putExtra("TriviaNumber", currentTrivia)

                    startActivity(intent)
                    //dont go back
                    finish()
                }
            }
        }
    }

    private fun updateUi(CurrentQuestion: Question) {
        binding.qpQuestion.text = CurrentQuestion.questionTxt
        binding.rbAnswerOne.text = CurrentQuestion.optionOne
        binding.rbAnswerTwo.text = CurrentQuestion.optionTwo
        binding.rbAnswerThree.text = CurrentQuestion.optionThree
        binding.rbAnswerFour.text = CurrentQuestion.optionFour
        binding.rbAnswerOne.setBackgroundResource(CurrentQuestion.rb)
        binding.rbAnswerTwo.setBackgroundResource(CurrentQuestion.rb)
        binding.rbAnswerThree.setBackgroundResource(CurrentQuestion.rb)
        binding.rbAnswerFour.setBackgroundResource(CurrentQuestion.rb)
        binding.qImage.setImageResource(CurrentQuestion.img)
        binding.qsAll.setBackgroundResource(CurrentQuestion.bg)
    }
}


package com.example.timelylemon

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.timelylemon.databinding.ActivityResultsBinding
import com.example.timelylemon.models.Constants
import com.example.timelylemon.models.Question

class ResultsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val finalScore = intent.getIntExtra("Score", 0);
        val username = intent.getStringExtra("username");
        val currentCat = intent.getIntExtra("QuestionNum", 1);

        val sharedPref = getSharedPreferences("Pref", MODE_PRIVATE)
        val lastUser  = sharedPref.getString(Constants.LAST_USER, "No One")
        val lastScore  = sharedPref.getInt(Constants.LAST_SCORE, 0)
        val lastCatOne = sharedPref.getInt(Constants.CAT_ONE_SCORE, 0)
        val lastCatTwo = sharedPref.getInt(Constants.CAT_TWO_SCORE, 0)
        val lastCatThree = sharedPref.getInt(Constants.CAT_THREE_SCORE, 0)

        binding.btnBack.setOnClickListener {
            saveResults(username.toString(), finalScore, currentCat)

            val backButton = Intent(this, LandingActivity::class.java)
            startActivity(backButton)
            finish()
        }

        binding.btnCat.setOnClickListener {
            saveResults(username.toString(), finalScore, currentCat)

            val catButton = Intent(this, CategorySelectActivity::class.java)
            catButton.putExtra("Score", finalScore)
            catButton.putExtra("username", username)
            startActivity(catButton)
            finish()
        }

        Log.i("CurrenntCat" , currentCat.toString())


        //update ui based on cat
        if(currentCat == 1){
            binding.resBack.setBackgroundResource(R.drawable.bg_android_sev)

            binding.finalScore.text = "Score: $finalScore/250"

            if(lastCatOne < finalScore){
                binding.newScore.text = "New High Score!"
            } else {
                binding.newScore.text = ""
            }

            if(finalScore >= 250){
                binding.bornResult.text = "$username, you are definitely a 70's kid"
                Log.i("Category Current", "One")
            } else if(finalScore in 101..200) {
                binding.bornResult.text = "$username, you just might be a 80's kid rather"
            } else if (finalScore in 49..100){
                binding.bornResult.text = "$username, you just might be a 90's kid rather"
            } else if(finalScore == 0){
                binding.bornResult.text = "Too bad!"
            }

        } else if(currentCat == 2) {
            binding.resBack.setBackgroundResource(R.drawable.bg_android_eight)

            binding.finalScore.text = "Score: $finalScore/250"

            if(lastCatTwo < finalScore){
                binding.newScore.text = "New High Score!"
            }   else {
                binding.newScore.text = ""
            }

            if(finalScore >= 250){
                binding.bornResult.text = "$username, you are definitely an 80's kid"
            } else if(finalScore in 101..200) {
                binding.bornResult.text = "$username, you just might be a 70's kid rather"
            } else if (finalScore in 49..100){
                binding.bornResult.text = "$username, you just might be a 90's kid rather"
            } else if(finalScore == 0){
                binding.bornResult.text = "Too bad!"
            }

        } else if(currentCat == 3){
            binding.resBack.setBackgroundResource(R.drawable.bg_android_nine)

            binding.finalScore.text = "Score: $finalScore/250"

            if(lastCatThree < finalScore){
                binding.newScore.text = "New High Score!"
            }   else {
                binding.newScore.text = ""
            }

            if(finalScore >= 250){
                binding.bornResult.text = "$username, you are definitely a 90's kid"
                Log.i("Category Current", "One")
            } else if(finalScore in 101..200) {
                binding.bornResult.text = "$username, you just might be a 80's kid rather"
            } else if (finalScore in 49..100){
                binding.bornResult.text = "$username, you just might be a 70's kid rather"
            } else if(finalScore == 0){
                binding.bornResult.text = "Too bad!"
            }

        }
    }

    private fun saveResults(username: String, finalScore: Int, currentCat: Int){
        val pref = getSharedPreferences("Pref", Context.MODE_PRIVATE)
        val editor = pref.edit()
        val prevScore = pref.getInt(Constants.LAST_SCORE, 0)
        val prevOneScore = pref.getInt(Constants.CAT_ONE_SCORE, 0)
        val prevTwoScore = pref.getInt(Constants.CAT_TWO_SCORE, 0)
        val prevThreeScore = pref.getInt(Constants.CAT_THREE_SCORE, 0)

        editor.apply{
            if(prevScore > finalScore){
                putString(Constants.LAST_USER, username)
                putInt(Constants.LAST_SCORE, prevScore)
                if(currentCat == 1){
                    putInt(Constants.CAT_ONE_SCORE, prevOneScore)
                } else if(currentCat == 2){
                    putInt(Constants.CAT_TWO_SCORE, prevTwoScore)
                } else if(currentCat == 3){
                    putInt(Constants.CAT_THREE_SCORE, prevThreeScore)
                }
                apply() //end

            } else {
                putString(Constants.LAST_USER, username)
                putInt(Constants.LAST_SCORE, finalScore)
                if(currentCat == 1){
                    putInt(Constants.CAT_ONE_SCORE, finalScore)
                } else if(currentCat == 2){
                    putInt(Constants.CAT_TWO_SCORE, finalScore)
                } else if(currentCat == 3){
                    putInt(Constants.CAT_THREE_SCORE, finalScore)
                }
                apply() //end
            }
        }
    }
}
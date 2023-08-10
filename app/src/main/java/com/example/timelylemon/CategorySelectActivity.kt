package com.example.timelylemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.view.WindowManager
import android.widget.TextView
import com.example.timelylemon.databinding.ActivityCategorySelectBinding
import com.example.timelylemon.models.Constants

class CategorySelectActivity : AppCompatActivity() {

    lateinit var data_receive : TextView

    private lateinit var binding: ActivityCategorySelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategorySelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        supportActionBar?.hide()

        data_receive = findViewById(R.id.high_one)

        val name = intent.getStringExtra("username")

        val sharedPref = getSharedPreferences("Pref", MODE_PRIVATE)
        val lastUser  = sharedPref.getString(Constants.LAST_USER, "No One")
        val lastCatOne = sharedPref.getInt(Constants.CAT_ONE_SCORE, 0)
        val lastCatTwo = sharedPref.getInt(Constants.CAT_TWO_SCORE, 0)
        val lastCatThree = sharedPref.getInt(Constants.CAT_THREE_SCORE, 0)

        binding.highOne.text = "Previous High Score: $lastCatOne"
        binding.highTwo.text = "Previous High Score: $lastCatTwo"
        binding.highThree.text = "Previous High Score: $lastCatThree"
        binding.selCat.text = "Choose a Category $name"

        binding.btnBack.setOnClickListener {
            val backButton = Intent(this, LandingActivity::class.java)
            startActivity(backButton)
        }

        binding.qzSeven.setOnClickListener {
            val startTrivia = Intent(this, QuestionsActivity::class.java)
            startTrivia.putExtra("TriviaNumber", 1)
            startTrivia.putExtra("username", name)
            startActivity(startTrivia)
            finish()
        }

        binding.qzEight.setOnClickListener {
            val startTrivia = Intent(this, QuestionsActivity::class.java)
            startTrivia.putExtra("TriviaNumber", 2)
            startTrivia.putExtra("username", name)
            startActivity(startTrivia)
            finish()
        }

        binding.qzNine.setOnClickListener {
            val startTrivia = Intent(this, QuestionsActivity::class.java)
            startTrivia.putExtra("TriviaNumber", 3)
            startTrivia.putExtra("username", name)
            startActivity(startTrivia)
            finish()
        }

    }

}
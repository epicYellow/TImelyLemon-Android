package com.example.timelylemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.Toast
import com.example.timelylemon.databinding.ActivityLandingBinding
import com.example.timelylemon.models.Constants
import com.google.android.material.snackbar.Snackbar

class LandingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        supportActionBar?.hide()

        val sharedPref = getSharedPreferences("Pref", MODE_PRIVATE)
        val lastUser  = sharedPref.getString(Constants.LAST_USER, "No One")
        val lastScore  = sharedPref.getInt(Constants.LAST_SCORE, 0)
        val lastCatOne = sharedPref.getInt(Constants.CAT_ONE_SCORE, 0)
        val lastCatTwo = sharedPref.getInt(Constants.CAT_TWO_SCORE, 0)
        val lastCatThree = sharedPref.getInt(Constants.CAT_THREE_SCORE, 0)
        val totalLastScore = lastCatOne + lastCatTwo + lastCatThree

        if(lastScore == 0){
            binding.prevScore.text = "Good Luck!"
        } else {
            binding.prevScore.text = "Previous Scores Total: $totalLastScore"
        }

        binding.btnSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        binding.btnStart.setOnClickListener {
            val username = binding.uName.text.toString()

            //check if empty
            if(username.toString() == ""){
                //Snackbar
                var snackbarMes = Snackbar.make(it, "Please enter your name", Snackbar.LENGTH_LONG)
                snackbarMes.setAction("ok",{})
                snackbarMes.show()

                binding.uName.error = "Please add username"
            } else {
                val intent = Intent(this, CategorySelectActivity::class.java)

                //parse data
                intent.putExtra("username", username.toString())
                startActivity(intent)
            }

        }
    }

}
package com.example.timelylemon

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.timelylemon.databinding.ActivitySettingsActivityBinding

import com.example.timelylemon.models.Constants

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        supportActionBar?.hide()

        val sharedPref = getSharedPreferences("Pref", MODE_PRIVATE)
        val lastUser = sharedPref.getString(Constants.LAST_USER, "No One")
        val lastScore = sharedPref.getInt(Constants.LAST_SCORE, 0)
        val lastCatOne = sharedPref.getInt(Constants.CAT_ONE_SCORE, 0)
        val lastCatTwo = sharedPref.getInt(Constants.CAT_TWO_SCORE, 0)
        val lastCatThree = sharedPref.getInt(Constants.CAT_THREE_SCORE, 0)
        val totalScore = lastCatOne + lastCatTwo + lastCatThree

        binding.setPrevName.text = lastUser
        binding.setPrevScore.text = "High Scores: $totalScore"

        //clear high score
        binding.btnClearHigh.setOnClickListener {
            val pref = getSharedPreferences("Pref", Context.MODE_PRIVATE)
            val editor = pref.edit()

            binding.setPrevName.text = "No One"
            binding.setPrevScore.text = "High Scores: 0"

            editor.apply {
                putString(Constants.LAST_USER, "No One")
                putInt(Constants.LAST_SCORE, 0)
                putInt(Constants.CAT_ONE_SCORE, 0)
                putInt(Constants.CAT_TWO_SCORE, 0)
                putInt(Constants.CAT_THREE_SCORE, 0)
                apply() //end
            }
        }

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
        }

        binding.linkGithub.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/EpicBlue1/TimelyLemon"));
            startActivity(browserIntent);
        }

            binding.linkWallpapers.setOnClickListener {
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://drive.google.com/file/d/1SwXcHJvZ8XLswMH9NlxUMMFmEw1DMTv7/view?usp=sharing")
                );
                startActivity(browserIntent);
            }


        }
    }

package com.example.timelylemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //full screen
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        supportActionBar?.hide()

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this,LandingActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
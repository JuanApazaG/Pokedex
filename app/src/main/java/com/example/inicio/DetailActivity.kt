package com.example.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Thread.sleep(1000)
        screenSplash.setKeepOnScreenCondition {false}

        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
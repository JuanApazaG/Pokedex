package com.example.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class screenActivity : AppCompatActivity() {
    private val tiempo:Long=2000
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_screen)
        Handler().postDelayed({
            val intent = Intent(this,LoginActivity::class.java)

            startActivity(intent)
            finish()

        },tiempo)



    }
}
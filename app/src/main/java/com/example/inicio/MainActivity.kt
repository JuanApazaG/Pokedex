package com.example.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val buttonAjustes = findViewById<Button>(R.id.buttonAjustes) as Button

        val buttonAcercaDe = findViewById<Button>(R.id.buttonAcercaDe) as Button
        val buttonSalir = findViewById<Button>(R.id.buttonSalir) as Button
        val buttonListaPokemon = findViewById<Button>(R.id.buttonListaPokemon) as Button


        buttonAjustes.setOnClickListener {
            val intent = Intent (this@MainActivity,Ajustes::class.java)
            startActivity(intent)
        }
        buttonAcercaDe.setOnClickListener {
            val intent = Intent (this@MainActivity,AcercaDe::class.java)
            startActivity(intent)
        }

        buttonSalir.setOnClickListener {
            finish()
        }
        buttonListaPokemon.setOnClickListener {
            val intent = Intent (this@MainActivity,ListaPokemon::class.java)
            startActivity(intent)
        }
    }
}
package com.example.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ListaPokemon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pokemon)

        val buttonpokemon_1 = findViewById<Button>(R.id.pokemon_1) as Button
        val buttpokemon_2 = findViewById<Button>(R.id.pokemon_2) as Button
        val buttpokemon_3 = findViewById<Button>(R.id.pokemon_3) as Button
        val buttpokemon_4 = findViewById<Button>(R.id.pokemon_4) as Button
        val buttpokemon_5 = findViewById<Button>(R.id.pokemon_5) as Button
        val buttpokemon_6 = findViewById<Button>(R.id.pokemon_6) as Button
        val info= findViewById<Button>(R.id.infor)as Button

        buttonpokemon_1.setOnClickListener {
            val intent = Intent (this@ListaPokemon,TarjetaPokemon::class.java)
            startActivity(intent)
        }

        buttpokemon_2.setOnClickListener {
            val intent = Intent (this@ListaPokemon,TarjetaPokemon::class.java)
            startActivity(intent)
        }

        buttpokemon_3.setOnClickListener {
            val intent = Intent (this@ListaPokemon,TarjetaPokemon::class.java)
            startActivity(intent)
        }
        buttpokemon_4.setOnClickListener {
            val intent = Intent (this@ListaPokemon,TarjetaPokemon::class.java)
            startActivity(intent)
        }
        buttpokemon_5.setOnClickListener {
            val intent = Intent (this@ListaPokemon,TarjetaPokemon::class.java)
            startActivity(intent)
        }
        buttpokemon_6.setOnClickListener {
            val intent = Intent (this@ListaPokemon,TarjetaPokemon::class.java)
            startActivity(intent)
        }
        info.setOnClickListener {
            val intent = Intent (this@ListaPokemon,TarjetaPokemon::class.java)
            startActivity(intent)
        }


    }





}
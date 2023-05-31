package com.example.inicio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.VideoView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    val TAG = "Datos"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val video = findViewById<VideoView>(R.id.video)
        val uri: Uri = Uri.parse(
            "android.resource://" + packageName + "/raw/intropokemon"
        )
        video.setVideoURI(uri)
        video.requestFocus()
        video.resume()
        video.start()


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
        getData()
    }

    private fun getData(){

        db.collection("Pokemones")
        //db.collection("Categoria")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        Log.d(TAG, document.id + " => " + document.data)
                    }
                } else {
                    Log.w(TAG, "Error getting documents.", task.exception)
                }
            }


    }

}
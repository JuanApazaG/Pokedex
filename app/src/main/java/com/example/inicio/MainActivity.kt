package com.example.inicio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.VideoView

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inicio.PokeApiv2.PokemonListActivity
import com.example.inicio.databinding.ActivityLoginBinding
import com.example.inicio.databinding.ActivityMainBinding

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.example.inicio.ui.view.MainActivity2



class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    val TAG = "Datos"

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityMainBinding

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        val buttonBuscar = findViewById<Button>(R.id.buttonBuscar) as Button


        buttonAjustes.setOnClickListener {
            val intent = Intent (this@MainActivity,Ajustes::class.java)
            startActivity(intent)
        }
        buttonAcercaDe.setOnClickListener {
            val intent = Intent (this@MainActivity,AcercaDe::class.java)
            startActivity(intent)
        }

        buttonSalir.setOnClickListener {
            val intent = Intent(this@MainActivity,PokemonListActivity::class.java)
            startActivity(intent)
        }
        buttonBuscar.setOnClickListener {
            val intent = Intent(this@MainActivity,PokemonListActivity::class.java)
            startActivity(intent)
        }
        buttonListaPokemon.setOnClickListener {
            val intent = Intent (this@MainActivity,MainActivity2::class.java)
            startActivity(intent)
        }

        getData()

    }





    private fun getData() {

//        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
//        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ItemsViewModel>()

        Log.d(TAG,"Recuperando")
        db.collection("Pokemones")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    data.add(ItemsViewModel("Pikachu", document.data.get("PokeName").toString() ))

                    //data.add(ItemsViewModel("100", document.data.get("Ataque").toString() ))
                    Log.d(TAG, "${document.id} => ${document.data}")


                }
                for (document in result) {
                    //data.add(ItemsViewModel("Pikachu", document.data.get("PokeName").toString() ))

                    data.add(ItemsViewModel("100", document.data.get("Ataque").toString() ))
                    Log.d(TAG, "${document.id} => ${document.data}")


                }
//                val adapter = CustomAdapter(data)
//                recyclerview.adapter = adapter
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }
    /*

    private fun getData(){
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ItemsViewModel>()
        for (i in 1..20) {
            data.add(ItemsViewModel("Oso", "Item " + i))
        }

        //aqui el espacio
        db.collection("Pokemones")
        //db.collection("Categoria")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        data.add(ItemsViewModel("Oso", document.data.get("nombre").toString() ))
                        Log.d(TAG, document.id + " => " + document.data)
                    }
                } else {
                    Log.w(TAG, "Error getting documents.", task.exception)
                }

                val adapter = CustomAdapter(data)
                recyclerview.adapter = adapter            }
    }
*/




}
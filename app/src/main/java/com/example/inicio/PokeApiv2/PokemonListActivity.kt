package com.example.inicio.PokeApiv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.inicio.databinding.ActivityPokemonListBinding
import modelPokeApi2.PokemonDb
import modelPokeApi2.PokemonDbClient
import modelPokeApi2.ThePokemonDbService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.concurrent.thread

class PokemonListActivity : AppCompatActivity(),OnQueryTextListener {
    private lateinit var binding:ActivityPokemonListBinding
    private lateinit var adapter: PokemonAdapter
    private val pokemonImages = mutableListOf<String>()
    private var nombre = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityPokemonListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buscador.setOnQueryTextListener(this)
        initrecycleview()

    }

    private fun initrecycleview() {
        adapter = PokemonAdapter(pokemonImages)
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter

    }

    private fun initrecycleviewv1() {

        binding.recycler.adapter = ListAdapter(
            mutableListOf(
                PokemonDb("pikachu","https://loremflickr.com/320/240?random=1"),
                PokemonDb("bulbasur","https://loremflickr.com/320/240?random=2"),
                PokemonDb("charizar","https://loremflickr.com/320/240?random=3"),
                PokemonDb("miew","https://loremflickr.com/320/240?random=4"),
                PokemonDb("rocket","https://loremflickr.com/320/240?random=5")


            )
        ) { pokemon ->
            Toast.makeText(this@PokemonListActivity, pokemon.url, Toast.LENGTH_LONG).show()
        }

        thread {
            val popularPokemon = PokemonDbClient.service.listPokemon()
            val body = popularPokemon.execute().body()
            if(body!=null)
                Log.d("MainActivity","Pokemon count: ${body.results.size}")
        }
    }


    //funcion que crea un objeto retrofit en cual hara las llamadas

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    funcion de busqueda por nombre
//
    private fun searchName(query:String){



        CoroutineScope(Dispatchers.IO).launch {



            val call = getRetrofit().create(ThePokemonDbService::class.java).listPokemonEspecifico("pokemon/$query")
            val pokemonEncontrado = call.body()
            runOnUiThread{
                if (call.isSuccessful){
                    //mostrar pokemon

                    val images = pokemonEncontrado?.sprites?.other?.official_artwork?.front_default?: null
                    if(images != null){
                        val imagesList = listOf<String>(images)
                        pokemonImages.clear()
                        pokemonImages.addAll(imagesList)
                        adapter.notifyDataSetChanged()
                    }

                }
                else{
                    //mostrar mensaje de error
                }
            }



        }
    }



    //    funcion de llamada a la lista completa de pokemones
//
    private fun searchList(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ThePokemonDbService::class.java).listPokemonEspecifico("pokemon?limit=100000&offset=0")
            val pokemonLista = call.body()
            if (call.isSuccessful){
                //mostrar pokemon
            }
            else{
                //mostrar mensaje de error
            }
        }

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            if(!query.isNullOrEmpty()){
                searchName(query.toLowerCase())
            }
        }
        if (query != null) {
            nombre= query
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}
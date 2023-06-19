package com.example.inicio.PokeApiv2

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.inicio.databinding.ViewPokemonItemV2Binding
import com.squareup.picasso.Picasso

class PokemonViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val binding = ViewPokemonItemV2Binding.bind(view)
    fun bind(image:String){
        Log.d("MainActivity","Pokemon url direccion: ${image}")

        Picasso.get().load(image).into(binding.cardimage)


    }
}
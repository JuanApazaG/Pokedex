package com.example.inicio.PokeApiv2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.inicio.databinding.ViewPokemonItemBinding
import modelPokeApi2.PokemonDb

interface PokemonClickListener{
    fun onPokemonClicker(pokemon: PokemonDb)
}

class ListAdapter(private var pokemones:List<PokemonDb>,
                  private val pokemonClickListener:(PokemonDb) ->  Unit):RecyclerView.Adapter<ListAdapter.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ViewPokemonItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false

        )
        return ViewHolder(binding)


    }

    override fun getItemCount(): Int {
        return pokemones.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemones[position]
        holder.bind(pokemon)
        holder.itemView.setOnClickListener{pokemonClickListener(pokemon)}
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class ViewHolder(private val binding:ViewPokemonItemBinding):RecyclerView.ViewHolder(binding.root){


        fun bind(pokemon:PokemonDb){
            binding.textPokemon.text=pokemon.name
            Glide.with(binding.root.context)
                .load(pokemon.url)
                .into(binding.imagePokemon)
        }
    }
}
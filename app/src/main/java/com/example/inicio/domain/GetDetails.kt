package com.example.inicio.domain

import com.example.inicio.data.PokeRepository
import com.example.inicio.domain.model.PokeItemDetails

class GetDetails {

    private val repository = PokeRepository()

    suspend fun fromPokemon(id: Int): PokeItemDetails? {
        return repository.getPokeDetails(id)
    }
}
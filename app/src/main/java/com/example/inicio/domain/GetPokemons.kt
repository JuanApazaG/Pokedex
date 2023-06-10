package com.example.inicio.domain

import com.example.inicio.data.PokeRepository
import com.example.inicio.domain.model.PokeItem

class GetPokemons {

    private val repository = PokeRepository()

    suspend fun listAll(): List<PokeItem> {
        return repository.getAllPokemons()
    }
}
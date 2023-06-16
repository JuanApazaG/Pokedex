package com.example.inicio.data

import com.example.inicio.domain.model.PokeItem
import com.example.inicio.domain.model.PokeItemDetails
import com.example.inicio.data.network.ApiService
import com.example.inicio.domain.model.toDomain

class PokeRepository {

    private val api = ApiService()

    suspend fun getAllPokemons(): List<PokeItem> {
        val response = api.getPokemons()
        return response.map { it.toDomain() }
    }

    suspend fun getPokeDetails(id: Int): PokeItemDetails? {
        val response = api.getDetailsPokemon(id)
        return response?.toDomain()
    }
}
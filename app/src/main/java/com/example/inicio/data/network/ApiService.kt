package com.example.inicio.data.network

import com.example.inicio.core.RetrofitHelper
import com.example.inicio.data.model.PokeModel
import com.example.inicio.data.model.PokeModelDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPokemons(): List<PokeModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getListPokemon()
            response.body()?.pokemons ?: emptyList()
        }
    }

    suspend fun getDetailsPokemon(id: Int): PokeModelDetails?{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getDetailsPokemon(id)
            response.body()
        }
    }


}
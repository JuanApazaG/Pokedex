package com.example.inicio.data

import com.example.inicio.data.domain.model.PokeItem
import com.example.inicio.data.domain.model.PokeItemDetails
import com.example.inicio.data.network.ApiService
import com.example.inicio.data.domain.model.toDomain

class PokeRepository {/*define la clase PokeRepository, que actúa como un repositorio de datos para acceder a los Pokémon y
sus detalles. Utiliza la clase ApiService para obtener los datos de la API de PokeAPI y luego los mapea a objetos del dominio.*/

    private val api = ApiService()/*El repositorio PokeRepository crea una instancia de ApiService para interactuar con la API de PokeAPI.*/

    suspend fun getAllPokemons(): List<PokeItem> {
        val response = api.getPokemons()
        return response.map { it.toDomain() }
    }/*El método getAllPokemons() utiliza la suspensión (suspend) y llama al método getPokemons() de ApiService para obtener
    la lista de Pokémon. Luego, mapea los objetos PokeModel obtenidos de la API a objetos del dominio PokeItem utilizando
    la función de extensión toDomain(). Finalmente, devuelve la lista de PokeItem.*/

    suspend fun getPokeDetails(id: Int): PokeItemDetails? {
        val response = api.getDetailsPokemon(id)
        return response?.toDomain()
    }/*El método getPokeDetails(id: Int) también utiliza la suspensión y llama al método getDetailsPokemon(id) de ApiService
    para obtener los detalles de un Pokémon específico. Luego, mapea el objeto PokeModelDetails obtenido de la API a un
    objeto del dominio PokeItemDetails utilizando la función de extensión toDomain().
    Devuelve el objeto PokeItemDetails si la respuesta es exitosa, o null en caso contrario.*/
}
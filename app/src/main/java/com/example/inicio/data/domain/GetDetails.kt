package com.example.inicio.data.domain

import com.example.inicio.data.PokeRepository
import com.example.inicio.data.domain.model.PokeItemDetails

class GetDetails {/* define la clase GetDetails, que es una clase del dominio de la aplicación. Su propósito es proporcionar
un punto de acceso para obtener los detalles de un Pokémon específico.*/



    private val repository = PokeRepository()
    /*La clase GetDetails tiene una dependencia en el repositorio PokeRepository. Utiliza una instancia de PokeRepository
    para acceder a los datos y obtener los detalles del Pokémon.*/

    suspend fun fromPokemon(id: Int): PokeItemDetails? {
        return repository.getPokeDetails(id)
    }/*El método fromPokemon(id: Int) es una función suspendida que recibe un identificador de Pokémon como parámetro. Luego,
    llama al método getPokeDetails(id) del repositorio PokeRepository para obtener los detalles del Pokémon correspondiente
    al identificador proporcionado. Devuelve el objeto PokeItemDetails si la respuesta del repositorio es exitosa, o null
    en caso contrario.*/
}
package com.example.inicio.data.domain

import com.example.inicio.data.PokeRepository
import com.example.inicio.data.domain.model.PokeItem

class GetPokemons {/*define la clase GetPokemons, que es una clase del dominio de la aplicación. Su propósito es proporcionar
un punto de acceso para obtener la lista de todos los Pokémon.*/

    private val repository = PokeRepository()
/*La clase GetPokemons tiene una dependencia en el repositorio PokeRepository. Utiliza una instancia de PokeRepository para
acceder a los datos y obtener la lista de todos los Pokémon.*/
    suspend fun listAll(): List<PokeItem> {
        return repository.getAllPokemons()
    }/*El método listAll() es una función suspendida que llama al método getAllPokemons() del repositorio PokeRepository
    para obtener la lista de todos los Pokémon. Devuelve la lista de objetos PokeItem si la respuesta del repositorio es
    exitosa, o una lista vacía en caso contrario.*/
}
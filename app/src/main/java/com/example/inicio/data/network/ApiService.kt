package com.example.inicio.data.network

import com.example.inicio.core.RetrofitHelper
import com.example.inicio.data.model.PokeModel
import com.example.inicio.data.model.PokeModelDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiService {/*ApiService, que actúa como un intermediario entre el código de la aplicación y la API de PokeAPI.
                    Proporciona métodos para obtener la lista de Pokémon y los detalles de un Pokémon específico.*/

    private val retrofit = RetrofitHelper.getRetrofit()/*La clase ApiService utiliza el objeto retrofit creado mediante
                                             la llamada a RetrofitHelper.getRetrofit() para realizar las solicitudes a la API.*/

    suspend fun getPokemons(): List<PokeModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getListPokemon()
            response.body()?.pokemons ?: emptyList()
        }
    }/*El método getPokemons() utiliza la suspensión (suspend) y el contexto de Dispatchers.IO para ejecutarse en un hilo de
    fondo. Dentro del bloque withContext, se realiza la solicitud a la API utilizando el método getListPokemon() del
    cliente de la API. Se obtiene la respuesta y se devuelve la lista de Pokémon (response.body()?.pokemons) si la
    respuesta es exitosa, o una lista vacía (emptyList()) en caso contrario.*/

    suspend fun getDetailsPokemon(id: Int): PokeModelDetails?{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getDetailsPokemon(id)
            response.body()
        }
    }/*El método getDetailsPokemon(id: Int) también utiliza la suspensión y el contexto de Dispatchers.IO.
    Dentro del bloque withContext, se realiza la solicitud a la API utilizando el método getDetailsPokemon(id)
    del cliente de la API, pasando el identificador del Pokémon como parámetro. Se obtiene la respuesta y se devuelve el
    objeto PokeModelDetails (response.body()) si la respuesta es exitosa, o null en caso contrario.*/


}
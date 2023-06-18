package com.example.inicio.data.network

import com.example.inicio.data.model.PokeModelDetails
import com.example.inicio.data.model.ResultApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient { /*interfaz ApiClient que proporciona los métodos para realizar solicitudes a la API de PokeAPI y obtener la lista de Pokémon y los detalles de un Pokémon específico.*/

    /*La anotación @GET se utiliza para indicar que estos métodos realizan solicitudes GET a las rutas especificadas
    en la URL base de la API.*/
    @GET(value = "pokemon?limit=1154")
    suspend fun getListPokemon(): Response<ResultApi>
/*El método getListPokemon() realiza una solicitud GET a la ruta "pokemon?limit=1154" para obtener la lista de Pokémon.
Utiliza la suspensión (suspend) para ejecutarse de forma asíncrona y devuelve un objeto Response<ResultApi>.
El objeto Response contiene la respuesta HTTP recibida, que incluye tanto los datos de la respuesta como el código de estado.*/

    @GET(value = "pokemon/{id}")
    suspend fun getDetailsPokemon(@Path("id") id: Int): Response<PokeModelDetails>

/*El método getDetailsPokemon() realiza una solicitud GET a la ruta "pokemon/{id}" para obtener los detalles de un
Pokémon específico. Utiliza la anotación @Path para especificar el valor del identificador del Pokémon en la URL.
También utiliza la suspensión (suspend) y devuelve un objeto Response<PokeModelDetails>.*/
}


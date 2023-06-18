package com.example.inicio.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val BASE_URL = "https://pokeapi.co/api/v2/" /*dirección principal de la API*/

    fun getRetrofit(): Retrofit { /*getRetrofit() devuelve una instancia de Retrofit con la configuración básica necesaria para comunicarse con la API de PokeAPI*/
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())/*agrega un convertidor de Gson (GsonConverterFactory.create()) que se encarga de convertir los datos JSON recibidos en objetos Java.*/
            .build()
    }
}
/*este código ayuda a configurar y obtener una instancia de Retrofit lista para realizar solicitudes a la API de PokeAPI
de forma sencilla y eficiente en el resto del código de la aplicación.*/
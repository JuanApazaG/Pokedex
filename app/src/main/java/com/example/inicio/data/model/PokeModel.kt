package com.example.inicio.data.model

import com.google.gson.annotations.SerializedName

data class ResultApi(
    @SerializedName("results") val pokemons: List<PokeModel>
)/*La clase ResultApi se utiliza para mapear la respuesta de la API que contiene una lista de objetos PokeModel.
La anotación @SerializedName se utiliza para vincular el nombre del atributo en la respuesta JSON con el nombre del atributo
en la clase ResultApi. En este caso, se espera que la respuesta JSON contenga un atributo llamado "results", que se mapeará
a la lista de objetos PokeModel llamada "pokemons" en la clase ResultApi.*/

data class PokeModel(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {

} /*La clase PokeModel se utiliza para representar un objeto Pokemon individual en la respuesta de la API.
Contiene dos atributos: name y url, que se corresponden con los campos "name" y "url" en la respuesta JSON,
respectivamente. Estos atributos se utilizan para almacenar el nombre y la URL del Pokemon.*/

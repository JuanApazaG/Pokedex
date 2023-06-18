package com.example.inicio.data.model

import com.google.gson.annotations.SerializedName


// https://pokeapi.co/api/v2/pokemon/25/

data class PokeModelDetails(
    @SerializedName("id") val id: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("name") val name: String,
    @SerializedName("sprites") val sprites: Sprites,
    @SerializedName("stats") val pokemonDetails: List<Stats>,
    @SerializedName("types") val types: List<Types>,
    @SerializedName("weight") val weight: Int,

    // falta:
    // - debelidades -> Array
)/*La clase PokeModelDetails representa los detalles de un Pokémon específico.
Contiene atributos como id (identificador del Pokémon), height (altura), name (nombre), sprites (imágenes del Pokémon),
pokemonDetails (detalles del Pokémon, como estadísticas) y types (tipos del Pokémon).
Además, también incluye el atributo weight (peso) que falta en el comentario.*/

data class Sprites(
    @SerializedName("other") val other: Other
)/*La clase Sprites representa las imágenes del Pokémon y contiene el objeto Other que a su vez tiene el atributo
officialArtwork para acceder a la imagen oficial del Pokémon.*/

data class Other(
    @SerializedName("official-artwork") val officialArtwork: OfficialArtwork
)

data class OfficialArtwork(
    @SerializedName("front_default") val img: String,
)/*La clase OfficialArtwork contiene el atributo img que representa la URL de la imagen frontal del Pokémon.*/

data class Stats(
    @SerializedName("base_stat") val statValue: Int,
    @SerializedName("stat") val stat: Stat
)/*La clase Stats representa las estadísticas de un Pokémon, como el valor base de la estadística (statValue)
y el objeto Stat que contiene el nombre de la estadística (statName).*/

data class Stat(
    @SerializedName("name") val statName: String
)/*La clase Stat contiene el nombre de una estadística específica del Pokémon.*/

data class Types(
    @SerializedName("type") val type: Type
)/*La clase Types representa los tipos del Pokémon y contiene el objeto Type.*/

data class Type(
    @SerializedName("name") val name: String
)/*La clase Type representa un tipo específico del Pokémon y contiene el nombre del tipo.*/

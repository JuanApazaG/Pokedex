package com.example.inicio.data.domain.model

import com.example.inicio.data.model.PokeModelDetails
import com.example.inicio.data.model.Types
import java.util.*

data class PokeItemDetails(
    val id: String,
    val name: String,
    val img: String,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val specialAttack: Int,
    val specialDefense:Int,
    val speed: Int,
    val types: List<String>,
    val weight: Double,
    val height: Double
)/*la clase PokeItemDetails en el dominio, que representa los detalles de un Pokémon, incluyendo propiedades como el
identificador, nombre, imagen, estadísticas, tipos, peso y altura.*/

fun PokeModelDetails.toDomain(): PokeItemDetails {
    val id = "N° ${id.toString().padStart(3,'0')}"
    val name = replaceFirstChar(name)
    val img = sprites.other.officialArtwork.img
    val hp = pokemonDetails[0].statValue
    val attack = pokemonDetails[1].statValue
    val defense = pokemonDetails[2].statValue
    val specialAttack = pokemonDetails[3].statValue
    val specialDefense = pokemonDetails[4].statValue
    val speed = pokemonDetails[5].statValue
    val types = getTypes(types)
    val weight = weight / 10.0
    val height = height / 10.0
    return PokeItemDetails(id, name, img, hp, attack, defense,
        specialAttack, specialDefense, speed, types, weight, height)
}/*La función de extensión toDomain() en la clase PokeModelDetails se utiliza para mapear un objeto PokeModelDetails de la
capa de datos al objeto de dominio PokeItemDetails. Esta función realiza el mapeo de los campos relevantes, como el
identificador, nombre, imagen y estadísticas. También formatea los tipos de Pokémon y convierte el peso y la altura de las
unidades proporcionadas por la API a unidades más comunes en el dominio.*/

private fun getTypes(types: List<Types>): List<String> {
    return if (types.size > 1) {
        listOf(replaceFirstChar(types[0].type.name), replaceFirstChar(types[1].type.name))
    } else {
        listOf(replaceFirstChar(types[0].type.name))
    }
}/*La función getTypes(types: List<Types>) se utiliza para obtener los tipos de un Pokémon y devuelve una lista de nombres
de tipos en formato capitalizado.*/

private fun replaceFirstChar(t: String): String {
    return t.replaceFirstChar {
        // cada nombre con Mayuscula
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }
}/*La función replaceFirstChar(t: String) se utiliza para reemplazar la primera letra de una cadena con la versión en
mayúscula. Esto se utiliza para formatear correctamente los nombres de los Pokémon y los tipos.*/
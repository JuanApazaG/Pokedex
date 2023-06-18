package com.example.inicio.data.domain.model

import com.example.inicio.data.model.PokeModel
import java.util.*

data class PokeItem(
    val id: Int,
    val name: String,
    val img: String
){
    val formatId = "N° ${id.toString().padStart(3,'0')}"
}/*define la clase PokeItem en el dominio, que representa un Pokémon con sus propiedades básicas como el
identificador, nombre e imagen. También incluye una propiedad formatId que formatea el identificador del Pokémon en un
formato específico, agregando ceros a la izquierda si es necesario.*/

private const val URL_RAW = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"
/*La constante URL_RAW define la URL base para obtener las imágenes oficiales de los Pokémon desde GitHub.*/
fun PokeModel.toDomain(): PokeItem {
    val arrayUrl = url.split("/")
    val id = arrayUrl[arrayUrl.size - 2].toInt()
    val name = name.replaceFirstChar {
        // cada nombre con Mayuscula
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }
    val img = "$URL_RAW$id.png"
    return PokeItem(id, name, img)
}/*La función de extensión toDomain() en la clase PokeModel se utiliza para mapear un objeto PokeModel de la capa de datos
al objeto de dominio PokeItem. Esta función realiza el mapeo de los campos relevantes, como el identificador,
el nombre y la URL de la imagen. Extrae el identificador del Pokémon de la URL, formatea el nombre del Pokémon con la
primera letra en mayúscula y genera la URL completa de la imagen utilizando el identificador.*/
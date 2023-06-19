package modelPokeApi2

data class PokemonDbResult(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<PokemonDb>
)
package modelPokeApi2


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonDbClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(ThePokemonDbService::class.java)

}

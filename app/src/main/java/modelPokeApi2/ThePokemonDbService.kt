package modelPokeApi2

import modelPokeApi2.PokemonFind
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

import retrofit2.http.Url

interface ThePokemonDbService{

    @GET("pokemon?limit=100000&offset=0")
    fun listPokemon(): Call<PokemonDbResult>

    @GET
    suspend fun listPokemonEspecifico(@Url url:String):Response<PokemonFind>

    @GET
    suspend fun listPokemonversion2(@Url url:String):Response<PokemonDbResult>




}
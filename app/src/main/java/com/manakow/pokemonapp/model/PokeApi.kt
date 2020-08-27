package com.manakow.pokemonapp.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PokeApi{
    class Instance{
        fun getRetrofit() : Retrofit{
            return Retrofit.Builder()
                .baseUrl(
                    "https://pokeapi.co/api/v2/"
                )
                .addConverterFactory(
                    GsonConverterFactory.create()
                )
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create()
                )
                .build()
        }

        fun getPokeApi() : PokeApi {
            return getRetrofit().create(PokeApi::class.java)
        }
    }

    @GET("pokemon/1")
    fun getPokemonByNumber() : Single<PokemonData>
}
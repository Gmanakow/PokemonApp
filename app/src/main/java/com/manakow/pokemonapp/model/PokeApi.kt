package com.manakow.pokemonapp.model

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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

    @GET("pokemon/{id}")
    fun getPokemonByNumber(
        @Path("id") id : Int
    ) : Single<PokemonData>

    @GET("pokemon/")
    fun getPokemonByCount(
        @Query("limit") limit : Int,
        @Query("offset") offset : Int
    ) : Single<LimitResultPD>
}
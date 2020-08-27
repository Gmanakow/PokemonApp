package com.manakow.pokemonapp.presenter

import android.util.Log
import com.manakow.pokemonapp.model.LimitResultPD
import com.manakow.pokemonapp.model.PokeApi
import com.manakow.pokemonapp.view.CustomView
import com.manakow.pokemonapp.view.MainActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class Presenter(val view : CustomView) {
    val pokeApi : PokeApi = PokeApi.Instance().getPokeApi()
    init{
        view.getButton()?.setOnClickListener {
            tick()
        }
    }

    fun tick(){
/*        pokeApi.getPokemonByNumber(35)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {it->
                Log.d(
                    "tag",
                    it.name!!
                )
            } */

        Log.d("tag", "check")
        pokeApi.getPokemonByCount(5, 5)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.results }
            .flattenAsObservable { it }
            .subscribe{
                Log.d("tag", it.name!!  )
            }


    }
}
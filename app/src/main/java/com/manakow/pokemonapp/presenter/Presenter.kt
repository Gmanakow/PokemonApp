package com.manakow.pokemonapp.presenter

import android.util.Log
import com.manakow.pokemonapp.model.PokeApi
import com.manakow.pokemonapp.view.CustomView
import com.manakow.pokemonapp.view.MainActivity
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
        pokeApi.getPokemonByNumber()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                Consumer {
                    Log.d(
                        "tag",
                        it.stats?.get(0)?.stat?.name!!
                    )
                }
            )
    }
}
package com.manakow.pokemonapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.manakow.pokemonapp.R
import com.manakow.pokemonapp.presenter.Presenter

class MainActivity : CustomView() {
    var tickButton : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView : TextView = findViewById(R.id.HelloViewId)
        textView.text = "PokemonApp"
        textView.visibility = View.VISIBLE


        tickButton = findViewById(R.id.buttonId)

        tickButton?.text = "Tick"
        tickButton?.visibility = View.VISIBLE

        val presenter : Presenter = Presenter(this)
    }

    override fun getButton(): Button? {
        return tickButton
    }

}
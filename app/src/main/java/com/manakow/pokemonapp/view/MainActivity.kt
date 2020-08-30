package com.manakow.pokemonapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.manakow.pokemonapp.R
import com.manakow.pokemonapp.model.LimitResultPD
import com.manakow.pokemonapp.presenter.Presenter
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import org.reactivestreams.Subscriber

class MainActivity : CustomView() {
    var tickButton : Button? = null
    var adapter : ReactiveRecyclerViewAdapter? = null
    var recyclerView : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tickButton = findViewById(R.id.buttonId)

        tickButton?.text = "Tick"
        tickButton?.visibility = View.VISIBLE

        val presenter : Presenter = Presenter(this)

        recyclerView = findViewById(R.id.pokemonItemRecycleView)
    }

    override fun getButton(): Button? {
        return tickButton
    }

}
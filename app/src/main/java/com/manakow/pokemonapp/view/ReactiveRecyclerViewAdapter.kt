package com.manakow.pokemonapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.manakow.pokemonapp.R
import com.manakow.pokemonapp.model.PokemonData

class ReactiveRecyclerViewAdapter(var list : ArrayList<PokemonData>) :
    RecyclerView.Adapter<ReactiveRecyclerViewAdapter.ReactiveViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReactiveViewHolder {
        return ReactiveViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.pokemon_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ReactiveViewHolder, position: Int) {
        holder.textView.text = list[position].name
    }

    class ReactiveViewHolder(v : View) : RecyclerView.ViewHolder(v){
        var textView : TextView = v.findViewById(R.id.pokemonItemNameTextView)
        var imageView : ImageView = v.findViewById(R.id.pokemonItemImageView)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

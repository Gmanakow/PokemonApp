package com.manakow.pokemonapp.view

import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

abstract class CustomView : AppCompatActivity(){
    abstract fun getButton() : Button?
}
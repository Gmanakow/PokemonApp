package com.manakow.pokemonapp.model

import java.lang.reflect.Type

class PokemonData {
    val name : String? = ""
    val sprites : SpritesPD? = null

    val weight : String? = ""
    val height : String? = ""

    val types : List<TypeItemPD>? = null
    val stats : List<StatItemPD>? = null

    class SpritesPD {
        val front_default : String = ""
    }

    class TypeItemPD{
        val type : TypePD? = null

        class TypePD{
            val name : String? = ""
        }
    }

    class StatItemPD{

        val base_stat : String? = ""
        val effort : String? = ""

        val stat : StatPD? = null

        class StatPD{
            val name : String? = ""
        }
    }
}
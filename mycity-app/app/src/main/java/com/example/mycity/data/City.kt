package com.example.mycity.data

import androidx.annotation.DrawableRes

data class City(
    val name : String = "",
    val map: MutableMap<Category, MutableList<Place>> = mutableMapOf()
)


data class Place(
    val name : String,
    val rating : Int,
    val description : String,
    @DrawableRes val img : Int = 0,
)

enum class Category {
    Parks, Restaurants, Theatres,
}




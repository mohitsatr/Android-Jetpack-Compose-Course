package com.example.mycity.data

data class MyCityUiState(
    val currentPlace: Category = Category.Parks,
    val currentCity: City = City(),
    val PlacesList: MutableList<Place>? = mutableListOf<Place>()
)

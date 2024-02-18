package com.example.mycity.local

import com.example.mycity.R
import com.example.mycity.data.Category
import com.example.mycity.data.City
import com.example.mycity.data.Place

object LocalCitiesData {
    val listofAll = listOf(
        City(
            "Ludhiana",
            map= mutableMapOf(
                Category.Parks to mutableListOf(LocalLudhiana.parks[0],LocalLudhiana.parks[1],LocalLudhiana.parks[2]),
                Category.Restaurants to mutableListOf(LocalLudhiana.resurants[0])
            )

        ),
        City(
            "Amsterdam",
            mutableMapOf(
                Category.Parks to mutableListOf(LocalAmsterdam.parks[0],LocalAmsterdam.parks[1],LocalAmsterdam.parks[2]),
                Category.Restaurants to mutableListOf(LocalAmsterdam.restaurants[0],LocalAmsterdam.restaurants[1],LocalAmsterdam.restaurants[2]) ,
                Category.Theatres to mutableListOf(LocalAmsterdam.theatres[0],LocalAmsterdam.theatres[1],LocalAmsterdam.theatres[2])
            )

        )
    )
}


object LocalLudhiana {
    val parks = listOf<Place>(
        Place("Dummy1",3,"Lorem ipsuum", R.drawable.lodhi_fort_1200x800),
        Place("Dummy2",1,"Tolerable",R.drawable.lodhi_fort_1200x800),
        Place("Dummy4",5,"Gorgeous", R.drawable.lodhi_fort_1200x800),
    )
    val theatre = listOf<Place>(
        Place("Dummy1",3,"Lorem ipsuum"),
        Place("Dummy2",1,"Tolerable"),
        Place("Dummy4",5,"Gorgeous"),
    )
    val resurants = listOf<Place>(
        Place("Dummy1",3,"Lorem ipsuum"),
        Place("Dummy2",1,"Tolerable"),
        Place("Dummy4",5,"Gorgeous"),
    )

}
object LocalAmsterdam {
    val parks = listOf(
        Place("Vondelpark", 4, "Beautiful park in the heart of Amsterdam",R.drawable.vondel),
        Place("Rembrandtpark", 3, "Scenic park with walking paths and lakes",R.drawable.vondel),
        Place("Westergasfabriek Park", 4, "Converted industrial area with green spaces",R.drawable.vondel)
    )

    val theatres = listOf(
        Place("Royal Theater Carré", 5, "Iconic theater hosting various performances"),
        Place("Stadsschouwburg Amsterdam", 4, "Historic theater offering diverse shows"),
        Place("DeLaMar Theater", 4, "Modern theater featuring plays and musicals")
    )

    val restaurants = listOf(
        Place("De Kas", 5, "Fine dining in a greenhouse setting"),
        Place("Foodhallen", 4, "Indoor food market with diverse cuisines"),
        Place("Café de Ceuvel", 4, "Eco-friendly café with sustainable dishes")
    )
}

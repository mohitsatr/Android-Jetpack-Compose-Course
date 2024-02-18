package com.example.mycity.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.data.Place
import com.example.mycity.ui.theme.MyCityTheme

@Composable
fun PlaceListScreen(
    currentCity: String,
    currentCategory: String,
    listofPlaces: MutableList<Place>?
){


    Column (){
        Text(text = "Showing ${listofPlaces?.size} $currentCategory in $currentCity")
        listofPlaces?.forEach {
            PlaceCard(cityName = it.name, cityDes = it.description, cityImage = it.img)
            Spacer(Modifier.size(4.dp))
        }
    }
}

@Composable
fun PlaceCard(
    cityName : String,
    cityDes : String,
    modifier : Modifier = Modifier.padding(horizontal = 8.dp),
    cityImage : Int = 0,

){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = modifier,

        ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(72.dp))
        {
            Column (
                modifier = Modifier.weight(1f)
            ){
                Text(
                    text = cityName,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = cityDes,
                    style = MaterialTheme.typography.bodyMedium,
                    overflow = TextOverflow.Visible,
                )
            }
            Box(modifier = Modifier){
                Image(
                    painterResource(id = cityImage),
                    contentDescription = "hero image",
                    modifier = Modifier
                        .padding()
                        .clip(RoundedCornerShape(8.dp))
                )
            }
        }
    }
}


@Composable
@Preview
fun Prev(){
    MyCityTheme {}
}

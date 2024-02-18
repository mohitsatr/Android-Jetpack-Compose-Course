package com.example.mycity.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mycity.data.Place

@Composable
fun PlaceDetailScreen(selectedPlace : Place, modifier: Modifier = Modifier, contentPadding: PaddingValues) {
    Column {
        Image(
            painter = painterResource(id = selectedPlace.img),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.clip(RoundedCornerShape(16.dp))


        )
        Text(text = selectedPlace.name)

    }
}
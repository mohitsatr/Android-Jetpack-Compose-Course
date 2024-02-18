package com.example.mycity.ui

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.data.Category
import com.example.mycity.data.City
import com.example.mycity.ui.theme.MyCityTheme

@Composable
fun StartScreen(
    onNextButtonClicked : (Category) -> Unit,
    onCitySelected : (City) -> Unit ,
    modifier : Modifier = Modifier,
    listOfCities : List<City>,
    categories: List<Category>
){

    Column {
        listOfCities.forEach{
            ExpandableCard(title = it, categories = categories,onNextButtonClicked, onCitySelected)
        }
    }

}

@Composable
private fun ExpandableCard(
    title : City ,
    categories : List<Category>,
    onButtonClicked : (Category) -> Unit,
    onCitySelected : (City) -> Unit
) {

    var expanded by remember { mutableStateOf (false) }

    ElevatedCard(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                expanded = !expanded
            }
    ) {
        Column(
        ) {
            Text(
                text = title.name,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(8.dp)
            )
            if (expanded) {
                Column {
                    categories.forEach{
                        Button(onClick = {
                            onButtonClicked(it)
                            onCitySelected(title)
                        } ) {
                            Text(text = it.name)
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun StarterScreenPreview(){
    MyCityTheme {
    }
}
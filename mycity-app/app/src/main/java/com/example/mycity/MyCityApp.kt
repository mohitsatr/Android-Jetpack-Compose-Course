package com.example.mycity

import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mycity.ui.MyCityViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mycity.data.Category
import com.example.mycity.data.Place
import com.example.mycity.local.LocalCitiesData
import com.example.mycity.local.LocalLudhiana
import com.example.mycity.ui.PlaceListScreen
import com.example.mycity.ui.StartScreen
import com.example.mycity.ui.theme.MyCityTheme
import com.example.mycity.utils.AppContentType

enum class MyCityAppScreens {
    Home,PlaceList,PlaceDetail
}


@Composable
fun MyCityHome(
    viewModel: MyCityViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    windowSize: WindowWidthSizeClass
){
    val contentType : AppContentType
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen =MyCityAppScreens.valueOf(
        backStackEntry?.destination?.route ?: MyCityAppScreens.Home.name )

    when (windowSize){
        WindowWidthSizeClass.Compact -> {
            contentType = AppContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded -> {
            contentType = AppContentType.LIST_AND_DETAIL
        }
        else -> {
            contentType = AppContentType.LIST_ONLY
        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    currentScreen: MyCityAppScreens,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(currentScreen.name) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}


@Composable
fun MyCityApplication(
    currentScreen : MyCityAppScreens,
    canNavigateBack: Boolean,
    navController : NavHostController,
    viewModel: MyCityViewModel,
    contentType: AppContentType
){
    Scaffold(topBar = {
        MyCityAppBar(
            currentScreen = currentScreen,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() }
        )
    }

    ) { innerPadding ->
        if (contentType == AppContentType.LIST_AND_DETAIL) {

        } else {

            val uiState by viewModel.uiState.collectAsState()
            NavHost(
                navController = navController,
                startDestination = MyCityAppScreens.Home.name,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = MyCityAppScreens.Home.name) {
                    StartScreen(
                        categories = Category.entries,
                        onCitySelected = {
                            viewModel.setCurrentCity(it)
                        },
                        onNextButtonClicked = {
                            viewModel.setScreen(it)
                            navController.navigate(MyCityAppScreens.PlaceList.name)
                        },
                        listOfCities = LocalCitiesData.listofAll,
                    )
                }

                composable(route = MyCityAppScreens.PlaceDetail.name) {

                }
                composable(route = MyCityAppScreens.PlaceList.name) {
                    viewModel.setListofPlaces()
                    PlaceListScreen(
                        currentCity = uiState.currentCity.name,
                        currentCategory = uiState.currentPlace.name,
                        listofPlaces = uiState.PlacesList
                    )//)listofPlaces = uiState.PlacesList)
                }

            }
        }
    }
}


@Composable
private fun MyCityListAndDetail(
    onClick: (Any) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Row(
        modifier = modifier
    ) {
//        SportsList(
//            sports = sports,
//            onClick = onClick,
//            contentPadding = contentPadding,
//            modifier = Modifier
//                .weight(2f)
//                .padding(horizontal = dimensionResource(R.dimen.padding_medium))
//        )

//        SportsDetail(
//            modifier = Modifier.weight(3f),
//            contentPadding = contentPadding,
//        )
    }
}


@Composable
@Preview
fun SportsPreview(){
    MyCityTheme {
//        PlaceDetailScreen(selectedPlace = , contentPadding = )Detail(
//            LocalLudhiana.parks[0],
//            modifier = Modifier,
//            contentPadding = PaddingValues(4.dp))
    }

}

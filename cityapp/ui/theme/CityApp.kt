package com.example.cityapp.ui.theme

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cityapp.data.List
import com.example.cityapp.model.CityHomeScreen

@Composable
fun CityApp (
    viewModel: CityViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = CityHomeScreen.valueOf(backStackEntry?.destination?.route?: CityHomeScreen.Start.name)
    val viewModel: CityViewModel = viewModel()

    Scaffold(
    ) {innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = CityHomeScreen.Start.name,
            )
        {
            composable(route = CityHomeScreen.Start.name) {
                CityHomeScreen(List = List.filter{it.type == "category"},
                    onCoffeeClicked = {navController.navigate(CityHomeScreen.Coffee.name)},
                    onRestaurantsClicked = {navController.navigate(CityHomeScreen.Restaurants.name)},
                    onParksClicked = {navController.navigate(CityHomeScreen.Parks.name)})
            }

            composable(route = CityHomeScreen.Coffee.name) {
                val context = LocalContext.current
                CityRecScreen(List = List.filter{it.type == "coffeeShop"})
            }

            composable(route = CityHomeScreen.Restaurants.name) {
                val context = LocalContext.current
                CityRecScreen(List = List.filter{it.type == "restaurant"})
            }

            composable(route = CityHomeScreen.Parks.name) {
                val context = LocalContext.current
                CityRecScreen(List = List.filter{it.type == "park"})
            }
        }
    }
}
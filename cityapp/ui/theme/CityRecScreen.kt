package com.example.cityapp.ui.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.cityapp.data.List
import com.example.cityapp.model.CityItem

@Composable
fun CityRecScreen(List: List<CityItem>) {

    CityList(
        List,
        onCoffeeClicked = {},
        onRestaurantsClicked = {},
        onParksClicked = {}
    )
}
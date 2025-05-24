package com.example.cityapp.model

data class CityItem(
    val category: String,
    val type: String
)

data class CityUiState(
    val List: List<CityItem> = emptyList(),
    val currentCategory: CityItem = CityItem("", "")
)

enum class CityHomeScreen(val title: Int) {
    Start(title = 0),
    Coffee(title = 1),
    Restaurants(title = 2),
    Parks(title = 3)
}
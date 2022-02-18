package com.example.jetpacktest

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RateReview
import androidx.compose.material.icons.filled.Shop
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Shop: BottomBarScreen(
        route = "shop",
        title = "Магазин",
        icon = Icons.Default.Shop
    )
    object Rating: BottomBarScreen(
        route = "rating",
        title = "Рейтинг",
        icon = Icons.Default.RateReview
    )
    object Profile: BottomBarScreen(
        route = "profile",
        title = "Профиль",
        icon = Icons.Default.Person
    )
}

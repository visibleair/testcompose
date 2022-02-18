package com.example.jetpacktest

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpacktest.screens.ProfileScreen
import com.example.jetpacktest.screens.RatingScreen
import com.example.jetpacktest.screens.ShopScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Rating.route
    ){
        composable(route = BottomBarScreen.Shop.route)
        {
            ShopScreen()
        }
        composable(route = BottomBarScreen.Rating.route)
        {
            RatingScreen()
        }
        composable(route = BottomBarScreen.Profile.route)
        {
            ProfileScreen()
        }
    }
}
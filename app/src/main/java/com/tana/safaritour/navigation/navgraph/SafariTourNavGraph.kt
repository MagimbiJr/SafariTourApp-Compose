package com.tana.safaritour.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun SafariTourNavGraph(
    navController: NavHostController
) {
    val isLoggedIn = false
    val route = if (isLoggedIn) {
        "bottom_navigation"
    } else {
        "authentication"
    }
    NavHost(navController = navController, startDestination = route) {
        bottomNavGraph(navController = navController)
        authNavGraph(navController = navController)
    }
}
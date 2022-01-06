package com.tana.safaritour.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tana.safaritour.navigation.routes.BottomNavRoutes

fun NavGraphBuilder.bottomNavGraph(navController: NavHostController) {
    navigation(BottomNavRoutes.Home.route, "bottom_navigation") {
        composable(BottomNavRoutes.Home.route) {}
        composable(BottomNavRoutes.Cart.route) {}
        composable(BottomNavRoutes.Setting.route) {}
        composable(BottomNavRoutes.Profile.route) {}
    }
}
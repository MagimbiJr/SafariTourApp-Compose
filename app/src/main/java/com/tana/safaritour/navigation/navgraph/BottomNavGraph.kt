package com.tana.safaritour.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.google.accompanist.systemuicontroller.SystemUiController
import com.tana.safaritour.bottom_nav.home.ui.HomeContent
import com.tana.safaritour.bottom_nav.home.ui.HomeScreen
import com.tana.safaritour.bottom_nav.home.ui.HomeScreenUiState
import com.tana.safaritour.navigation.routes.BottomNavRoutes

fun NavGraphBuilder.bottomNavGraph(systemUiController: SystemUiController) {
    navigation(BottomNavRoutes.Home.route, "bottom_navigation") {
        composable(BottomNavRoutes.Home.route) { HomeScreen(systemUiController = systemUiController) }
        composable(BottomNavRoutes.Cart.route) {}
        composable(BottomNavRoutes.Setting.route) {}
        composable(BottomNavRoutes.Profile.route) {}
    }
}
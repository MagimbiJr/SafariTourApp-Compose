package com.tana.safaritour.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tana.safaritour.navigation.routes.AuthRoutes

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(AuthRoutes.Landing.route, "authentication",) {
        composable(AuthRoutes.Landing.route) {}
        composable(AuthRoutes.Login.route) {}
        composable(AuthRoutes.SignUp.route) {}
    }
}
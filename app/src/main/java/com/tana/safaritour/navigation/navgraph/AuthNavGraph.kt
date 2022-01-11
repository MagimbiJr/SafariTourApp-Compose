package com.tana.safaritour.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.google.accompanist.systemuicontroller.SystemUiController
import com.tana.safaritour.authentication.landing.LandingScreen
import com.tana.safaritour.authentication.login.ui.LoginScreen
import com.tana.safaritour.authentication.signup.ui.SignUpScreen
import com.tana.safaritour.navigation.routes.AuthRoutes

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
    systemUiController: SystemUiController
) {
    navigation(AuthRoutes.Landing.route, "authentication",) {
        composable(AuthRoutes.Landing.route) { LandingScreen(navController = navController, systemUiController = systemUiController)}
        composable(AuthRoutes.Login.route) {
            LoginScreen(
                navController = navController,
                systemUiController = systemUiController
            )
        }
        composable(AuthRoutes.SignUp.route) {
            SignUpScreen(
                systemUiController = systemUiController,
                navHostController = navController
            )
        }
    }
}
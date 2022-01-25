package com.tana.safaritour.navigation.navgraph

import androidx.compose.foundation.ScrollState
import androidx.compose.material.ScaffoldState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.google.accompanist.systemuicontroller.SystemUiController
import com.tana.safaritour.authentication.landing.LandingScreen
import com.tana.safaritour.authentication.login.ui.LoginScreen
import com.tana.safaritour.authentication.signup.ui.SignUpScreen
import com.tana.safaritour.navigation.routes.AuthRoutes
import kotlinx.coroutines.CoroutineScope

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
    systemUiController: SystemUiController,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
    scrollState: ScrollState,
) {
    navigation(AuthRoutes.Landing.route, "authentication") {
        composable(AuthRoutes.Landing.route) {
            LandingScreen(
                navController = navController,
                systemUiController = systemUiController
            )
        }
        composable(AuthRoutes.Login.route) {
            LoginScreen(
                scrollState = scrollState,
                onNavigate = {
                    navController.navigate(it.route) {
                        popUpTo(AuthRoutes.Landing.route)
                    }
                },
                systemUiController = systemUiController
            )
        }
        composable(AuthRoutes.SignUp.route) {
            SignUpScreen(
                systemUiController = systemUiController,
                scrollState = scrollState,
                scaffoldState = scaffoldState,
                coroutineScope = coroutineScope,
                onNavigate = {
                    navController.navigate(it.route) {
                        popUpTo(AuthRoutes.Landing.route)
                    }
                }
            )
        }
    }
}
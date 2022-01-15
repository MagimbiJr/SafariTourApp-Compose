package com.tana.safaritour.navigation.navgraph

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope

@Composable
fun SafariTourNavGraph(
    navController: NavHostController,
    systemUiController: SystemUiController,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope
) {
    val auth = FirebaseAuth.getInstance()
    //val isLoggedIn = (auth.currentUser != null)
    val route = if (auth.currentUser == null) {
        "bottom_navigation"
    } else {
        "authentication"
    }
    NavHost(navController = navController, startDestination = route) {
        bottomNavGraph(navController = navController)
        authNavGraph(
            navController = navController,
            systemUiController = systemUiController,
            scaffoldState = scaffoldState,
            coroutineScope = coroutineScope
        )
    }
}
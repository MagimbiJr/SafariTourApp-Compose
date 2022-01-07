package com.tana.safaritour.navigation.routes

sealed class AuthRoutes(val route: String) {
    object Landing : AuthRoutes(route = "landing_screen")
    object Login : AuthRoutes(route = "login_screen")
    object SignUp : AuthRoutes(route = "signup_screen")
}

sealed class OtherAppRoutes(val route: String) {
    object Details : OtherAppRoutes(route = "details_screen")
}

sealed class BottomNavRoutes(val route: String) {
    object Home : BottomNavRoutes(route = "home_screen")
    object Cart : BottomNavRoutes(route = "cart_screen")
    object Setting : BottomNavRoutes(route = "setting_screen")
    object Profile : BottomNavRoutes(route = "profile_screen")
}
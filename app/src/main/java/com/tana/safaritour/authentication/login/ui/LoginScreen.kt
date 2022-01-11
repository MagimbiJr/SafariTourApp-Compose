package com.tana.safaritour.authentication.login.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.tana.safaritour.navigation.routes.AuthRoutes

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    systemUiController: SystemUiController,
    navController: NavHostController
) {
    systemUiController.setSystemBarsColor(MaterialTheme.colors.background)
    val loginUiState = viewModel.uiState.collectAsState()

    LoginContent(
        loginUiState = loginUiState.value,
        onEmailChanged = viewModel::emailChanged,
        onPasswordChanged = viewModel::passwordChanged,
        onLoginButtonClicked = {
            viewModel.loginButtonClicked()
        },
        onCreateAccountButtonClicked = {
            navController.navigate(AuthRoutes.SignUp.route)
        }
    )
}
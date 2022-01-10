package com.tana.safaritour.authentication.signup.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.tana.safaritour.navigation.routes.AuthRoutes
import com.tana.safaritour.navigation.routes.BottomNavRoutes

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    systemUiController: SystemUiController,
    navHostController: NavHostController
) {
    systemUiController.setSystemBarsColor(color = MaterialTheme.colors.background)
    val signUpUiState = viewModel.uiState.collectAsState()
    SignUpContent(
        signUpUiState = signUpUiState.value,
        onNameChanged = viewModel::nameChanged,
        onEmailChanged = viewModel::emailChanged,
        onPasswordChanged = viewModel::passwordChanged,
        onReTypePasswordChanged = viewModel::reTypePasswordChanged,
        onSignUpButtonClicked = {
            viewModel.signUpButtonClicked()
            //navHostController.navigate(BottomNavRoutes.Home.route)
        },
        onLoginButtonClicked = {
            //viewModel.loginButtonClicked()
            navHostController.navigate(AuthRoutes.Login.route)
        }
    )
}
package com.tana.safaritour.authentication.login.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.tana.safaritour.navigation.routes.AuthRoutes
import com.tana.safaritour.utils.AppUiEvents
import kotlinx.coroutines.flow.collect

@Composable
fun LoginScreen(
    onNavigate: (AppUiEvents.Navigate) -> Unit,
    viewModel: LoginViewModel = hiltViewModel(),
    systemUiController: SystemUiController,
    //navController: NavHostController
) {
    systemUiController.setSystemBarsColor(MaterialTheme.colors.background)
    val loginUiState = viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.appUiEvents.collect { event ->
            when(event) {
                is AppUiEvents.PopBackStack -> Unit
                is AppUiEvents.ShowSnackBar -> Unit
                is AppUiEvents.Navigate -> onNavigate(event)
            }
        }
    }

    LoginContent(
        loginUiState = loginUiState.value,
        onEmailChanged = viewModel::emailChanged,
        onPasswordChanged = viewModel::passwordChanged,
        onLoginButtonClicked = viewModel::loginButtonClicked,
        onCreateAccountButtonClicked = viewModel::signUpButtonClicked
    )
}
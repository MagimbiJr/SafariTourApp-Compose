package com.tana.safaritour.authentication.signup.ui

import android.widget.Toast
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current
    SignUpContent(
        signUpUiState = signUpUiState.value,
        onNameChanged = viewModel::nameChanged,
        onEmailChanged = viewModel::emailChanged,
        onPasswordChanged = viewModel::passwordChanged,
        onReTypePasswordChanged = viewModel::reTypePasswordChanged,
        onSignUpButtonClicked = {
            viewModel.signUpButtonClicked()
            Toast.makeText(context, "User created successful", Toast.LENGTH_SHORT).show()
            navHostController.navigate(BottomNavRoutes.Home.route)
        },
        onLoginButtonClicked = {
            //viewModel.loginButtonClicked()
            navHostController.navigate(AuthRoutes.Login.route)
        }
    )
}
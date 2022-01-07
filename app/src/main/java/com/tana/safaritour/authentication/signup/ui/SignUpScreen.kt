package com.tana.safaritour.authentication.signup.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.systemuicontroller.SystemUiController

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = viewModel(),
    systemUiController: SystemUiController
) {
    systemUiController.setSystemBarsColor(color = MaterialTheme.colors.background)
    val signUpUiState = viewModel.uiState.collectAsState()
    SignUpContent(
        signUpUiState = signUpUiState.value,
        onNameChanged = viewModel::nameChanged,
        onEmailChanged = viewModel::emailChanged,
        onPasswordChanged = viewModel::passwordChanged,
        onReTypePasswordChanged = viewModel::reTypePasswordChanged,
        onSignUpButtonClicked = viewModel::signUpButtonClicked,
        onLoginButtonClicked = viewModel::loginButtonClicked)
}
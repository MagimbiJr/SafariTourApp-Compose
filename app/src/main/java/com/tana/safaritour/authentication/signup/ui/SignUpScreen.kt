package com.tana.safaritour.authentication.signup.ui

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.tana.safaritour.navigation.routes.AuthRoutes
import com.tana.safaritour.navigation.routes.BottomNavRoutes
import com.tana.safaritour.utils.AppUiEvents
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(
    onNavigate: (AppUiEvents.Navigate) -> Unit,
    viewModel: SignUpViewModel = hiltViewModel(),
    systemUiController: SystemUiController,
    //navHostController: NavHostController,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
    modifier: Modifier = Modifier
) {
    systemUiController.setSystemBarsColor(color = MaterialTheme.colors.background)
    val signUpUiState = viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.appUiEvents.collect { event ->
            when(event) {
                is AppUiEvents.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = "User created successful"
                    )
                }
                is AppUiEvents.Navigate -> onNavigate(event)
                is AppUiEvents.PopBackStack -> Unit
            }
        }
    }
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        SignUpContent(
            signUpUiState = signUpUiState.value,
            onNameChanged = viewModel::nameChanged,
            onEmailChanged = viewModel::emailChanged,
            onPasswordChanged = viewModel::passwordChanged,
            onReTypePasswordChanged = viewModel::reTypePasswordChanged,
            onSignUpButtonClicked = viewModel::signUpButtonClicked,
            onLoginButtonClicked = viewModel::loginButtonClicked
        )
    }
}
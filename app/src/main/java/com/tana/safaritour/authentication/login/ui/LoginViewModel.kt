package com.tana.safaritour.authentication.login.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tana.safaritour.authentication.login.data.LoginCredential
import com.tana.safaritour.authentication.login.data.LoginRepository
import com.tana.safaritour.navigation.routes.AuthRoutes
import com.tana.safaritour.navigation.routes.BottomNavRoutes
import com.tana.safaritour.utils.AppUiEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState(errorMessage = repository.errorMessage.value))
    val uiState = _uiState.asStateFlow()
    private val _appUiEvents = Channel<AppUiEvents>()
    val appUiEvents = _appUiEvents.receiveAsFlow()
    val errorMessage = repository.errorMessage.value

    fun emailChanged(email: String) {
        val currentCredentials = _uiState.value.credentials
        _uiState.value = _uiState.value.copy(
            credentials = currentCredentials.copy(
                email = email
            )
        )
    }


    fun passwordChanged(password: String) {
        val currentCredentials = _uiState.value.credentials
        _uiState.value = _uiState.value.copy(
            credentials = currentCredentials.copy(
                password = password
            )
        )
    }

    fun loginButtonClicked() {
        val currentCredentials = _uiState.value.credentials

        verifyInputs(currentCredentials)

        if (currentCredentials.email.isNotBlank() && currentCredentials.password.isNotBlank()) {
            repository.login(
                currentCredentials.email.trim(),
                currentCredentials.password.trim()
            )
        }

        _uiState.value = _uiState.value.copy(
            submitting = true
        )

        _uiState.value = _uiState.value.copy(
            submitting = false
        )
        _uiState.value = _uiState.value.copy(
            errorMessage = repository.errorMessage.value
        )

        if (repository.currentUser.value != null) {
            viewModelScope.launch {
                _appUiEvents.send(AppUiEvents.Navigate(BottomNavRoutes.Home.route))
            }
        }
    }

    fun signUpButtonClicked() {
        viewModelScope.launch {
            _appUiEvents.send(AppUiEvents.Navigate(AuthRoutes.SignUp.route))
        }
    }

    private fun verifyInputs(credential: LoginCredential) {
        if (credential.email.isBlank()) {
            _uiState.value = _uiState.value.copy(
                emailInputErrorMessage = "Please enter email."
            )
        } else {
            _uiState.value = _uiState.value.copy(
                emailInputErrorMessage = null
            )
        }

        if (credential.password.isBlank()) {
            _uiState.value = _uiState.value.copy(
                passwordInputErrorMessage = "Please enter password."
            )
        } else if(credential.password.length < 6){
            _uiState.value = _uiState.value.copy(
                passwordInputErrorMessage = "Password must be greater than 6 character."
            )
        } else {
            _uiState.value = _uiState.value.copy(
                passwordInputErrorMessage = null
            )
        }
    }
}
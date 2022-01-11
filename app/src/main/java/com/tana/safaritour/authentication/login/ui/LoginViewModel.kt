package com.tana.safaritour.authentication.login.ui

import androidx.lifecycle.ViewModel
import com.tana.safaritour.authentication.login.data.LoginCredential
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

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
        if (
            currentCredentials.email.isBlank() ||
            currentCredentials.password.isBlank()
        ) {
            _uiState.value = _uiState.value.copy(
                submitting = false
            )
        } else {
            _uiState.value = _uiState.value.copy(
                submitting = true
            )
        }
//        repository.createUser(credentials = currentCredentials)
//        if (currentUser.value != null) {
//            _uiState.value = _uiState.value.copy(
//                submitting = false
//            )
//        } else {
//            _uiState.value = _uiState.value.copy(
//                submitting = true
//            )
//        }
    }

    private fun verifyInputs(credential: LoginCredential) {
        if (credential.email.isBlank()) {
            _uiState.value = _uiState.value.copy(
                emailInputErrorMessage = "Please enter email"
            )
        } else {
            _uiState.value = _uiState.value.copy(
                emailInputErrorMessage = null
            )
        }

        if (credential.password.isBlank()) {
            _uiState.value = _uiState.value.copy(
                passwordInputErrorMessage = "Please enter password"
            )
        } else if(credential.password.length < 6){
            _uiState.value = _uiState.value.copy(
                emailInputErrorMessage = "Password must be greater than 6 character"
            )
        } else {
            _uiState.value = _uiState.value.copy(
                emailInputErrorMessage = null
            )
        }
    }
}
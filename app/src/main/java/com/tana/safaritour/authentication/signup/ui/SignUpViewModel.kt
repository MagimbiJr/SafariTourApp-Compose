package com.tana.safaritour.authentication.signup.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignUpViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<SignUpUiState>(SignUpUiState.Initial)
    val uiState = _uiState.asStateFlow()
    val isLoading: StateFlow<Boolean> = MutableStateFlow(false)

    /**
     * Event requested for changing name in the name text field
     * @param[name] current name in the field
     */
    fun nameChanged(name: String) {
        val currentCredentials = _uiState.value.credentials
        _uiState.value = SignUpUiState.Active(
            credentials = currentCredentials.copy(
                name = name
            )
        )
    }

    /**
     * Event requested for changing email in the email text field
     * @param[email] current email in the text filed
     */
    fun emailChanged(email: String) {
        val currentCredentials = _uiState.value.credentials
        _uiState.value = SignUpUiState.Active(
            credentials = currentCredentials.copy(
                email = email
            )
        )
    }

    /**
     * Event requested for changing password in the email text field
     * @param[password] current password in the text filed
     */
    fun passwordChanged(password: String) {
        val currentCredentials = _uiState.value.credentials
        _uiState.value = SignUpUiState.Active(
            credentials = currentCredentials.copy(
                password = password
            )
        )
    }

    /**
     * Event requested for changing verified password in the email text field
     * @param[reTypePassword] current password in the text filed
     */
    fun reTypePasswordChanged(reTypePassword: String) {
        val currentCredentials = _uiState.value.credentials
        _uiState.value = SignUpUiState.Active(
            credentials = currentCredentials.copy(
                reTypePassword = reTypePassword
            )
        )
    }

    /**
     * A function that handles submission. When user click Create account button
     */
    fun signUpButtonClicked() {}

    /**
     * A function that navigate user to login screen. If they already have account ant click login button
     */
    fun loginButtonClicked() {}
}

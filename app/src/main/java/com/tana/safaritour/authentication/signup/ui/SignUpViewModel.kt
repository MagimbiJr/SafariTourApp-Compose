package com.tana.safaritour.authentication.signup.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tana.safaritour.authentication.signup.data.RegistrationRepository
import com.tana.safaritour.authentication.signup.data.SignUpCredentials
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: RegistrationRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<SignUpUiState>(SignUpUiState.Initial)
    val uiState = _uiState.asStateFlow()

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
    fun signUpButtonClicked() {
        val currentCredentials = _uiState.value.credentials


//        _uiState.value = SignUpUiState.Submitting(
//            credentials = currentCredentials
//        )
        verifyInputs(currentCredentials)

    }

    /**
     * A function that navigate user to login screen. If they already have account ant click login button
     */
    fun loginButtonClicked() {
        viewModelScope.launch {

        }
    }

    private fun verifyInputs(credentials: SignUpCredentials) {
        _uiState.value = SignUpUiState.Active(
            credentials = credentials,
            nameInputErrorMessage = if (credentials.name.isBlank()) {
                "Please enter name."
            } else {
                null
            },
            emailInputErrorMessage = if (credentials.email.isBlank()) {
                "Please enter email."
            } else {
                null
            },
            passwordInputErrorMessage = if (credentials.password.isBlank()) {
                "Please enter password."
            } else if (credentials.password.length < 6) {
                "Password must be greater than 6 character"
            } else {
                null
            },
            reTypePasswordInputErrorMessage = if (credentials.reTypePassword.isBlank()) {
                "Please verify password"
            } else if (credentials.password != credentials.reTypePassword) {
                "Password do not match"
            } else if (credentials.reTypePassword.length < 6) {
                "Password must be greater than 6 character"
            } else {
                null
            }
        )
    }
}

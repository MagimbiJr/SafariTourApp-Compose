package com.tana.safaritour.authentication.signup.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseUser
import com.tana.safaritour.authentication.signup.data.RegistrationRepository
import com.tana.safaritour.authentication.signup.data.SignUpCredentials
import com.tana.safaritour.navigation.routes.AuthRoutes
import com.tana.safaritour.navigation.routes.BottomNavRoutes
import com.tana.safaritour.utils.AppUiEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: RegistrationRepository,
) : ViewModel() {
    private val _appUiEvents = Channel<AppUiEvents>()
    val appUiEvents = _appUiEvents.receiveAsFlow()
    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState = _uiState.asStateFlow()
    val currentUser = repository.currentUser
    val errorMessage = repository.errorMessage.value
    val showSignUpSnackbar = MutableStateFlow(false)
    var navigate = false

    /**
     * Event requested for changing name in the name text field
     * @param[name] current name in the field
     */
    fun nameChanged(name: String) {
        val currentCredentials = _uiState.value.credentials

        _uiState.value = _uiState.value.copy(
            credentials = currentCredentials.copy(name = name)
        )
    }

    /**
     * Event requested for changing email in the email text field
     * @param[email] current email in the text filed
     */
    fun emailChanged(email: String) {
        val currentCredentials = _uiState.value.credentials
        _uiState.value = _uiState.value.copy(
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
        _uiState.value = _uiState.value.copy(
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
        _uiState.value = _uiState.value.copy(
            credentials = currentCredentials.copy(
                reTypePassword = reTypePassword
            )
        )

    }

    /**
     * A function that handles submission. When user click Create account button
     */
    fun signUpButtonClicked() {
        _uiState.value = _uiState.value.copy(
            submitting = true
        )

        val currentCredentials = _uiState.value.credentials

        verifyInputs(currentCredentials)

        if (currentCredentials.email.isNotBlank() && currentCredentials.password.isNotBlank()) {
            repository.createUser(
                currentCredentials.name.trim(),
                currentCredentials.email.trim(),
                currentCredentials.password.trim(),
                currentCredentials.profileDp.trim()
            )
        }
        Log.d("TAG", "signUpButtonClicked: ${repository.errorMessage.value}")
        _uiState.value = _uiState.value.copy(
            errorMessage = repository.errorMessage.value
        )
        _uiState.value = _uiState.value.copy(
            submitting = false
        )

        if (repository.currentUser.value != null) {
            viewModelScope.launch {
                _appUiEvents.send(AppUiEvents.Navigate(BottomNavRoutes.Home.route))
            }
        }
    }

    /**
     * A function that navigate user to login screen. If they already have account ant click login button
     */
    fun loginButtonClicked() {
        viewModelScope.launch {
            _appUiEvents.send(AppUiEvents.Navigate(AuthRoutes.Login.route))
        }
    }

    private fun verifyInputs(credentials: SignUpCredentials) {
        if (credentials.name.isBlank()) {
            _uiState.value = _uiState.value.copy(
                nameInputErrorMessage = "Please enter name."
            )
        } else {
            _uiState.value = _uiState.value.copy(
                nameInputErrorMessage = null
            )
        }

        if (credentials.email.isBlank()) {
            _uiState.value = _uiState.value.copy(
                emailInputErrorMessage = "Please enter email."
            )
        } else {
            _uiState.value = _uiState.value.copy(
                emailInputErrorMessage = null
            )
        }

        if (credentials.password.isBlank()) {
            _uiState.value = _uiState.value.copy(
                passwordInputErrorMessage = "Please enter password."
            )
        } else if (credentials.password.length < 6) {
            _uiState.value = _uiState.value.copy(
                passwordInputErrorMessage = "Password must be greater than 6 character."
            )
        } else {
            _uiState.value = _uiState.value.copy(
                passwordInputErrorMessage = null
            )
        }

        if (credentials.reTypePassword.isBlank()) {
            _uiState.value = _uiState.value.copy(
                reTypePasswordInputErrorMessage = "Please verify password."
            )
        } else if (credentials.reTypePassword.length < 6) {
            _uiState.value = _uiState.value.copy(
                reTypePasswordInputErrorMessage = "Password must be greater than 6 character."
            )
        } else if (credentials.password != credentials.reTypePassword) {
            _uiState.value = _uiState.value.copy(
                reTypePasswordInputErrorMessage = "Password do not match."
            )
        } else {
            _uiState.value = _uiState.value.copy(
                reTypePasswordInputErrorMessage = null
            )
        }
    }

//    private fun verifyInputs(credentials: SignUpCredentials) {
//        _uiState.value = SignUpUiState.Active(
//            credentials = credentials,
//            nameInputErrorMessage = if (credentials.name.isBlank()) {
//                "Please enter name."
//            } else {
//                null
//            },
//            emailInputErrorMessage = if (credentials.email.isBlank()) {
//                "Please enter email."
//            } else {
//                null
//            },
//            passwordInputErrorMessage = if (credentials.password.isBlank()) {
//                "Please enter password."
//            } else if (credentials.password.length < 6) {
//                "Password must be greater than 6 character"
//            } else {
//                null
//            },
//            reTypePasswordInputErrorMessage = if (credentials.reTypePassword.isBlank()) {
//                "Please verify password"
//            } else if (credentials.password != credentials.reTypePassword) {
//                "Password do not match"
//            } else if (credentials.reTypePassword.length < 6) {
//                "Password must be greater than 6 character"
//            } else {
//                null
//            }
//        )
//    }
}

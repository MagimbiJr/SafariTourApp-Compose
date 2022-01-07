package com.tana.safaritour.authentication.signup.ui

import com.tana.safaritour.authentication.signup.data.SignUpCredentials

sealed class SignUpUiState(
    open val credentials: SignUpCredentials,
    open val buttonEnabled: Boolean = true
) {
    object Initial : SignUpUiState(credentials = SignUpCredentials())

    data class Active(
        override val credentials: SignUpCredentials
    ) : SignUpUiState(credentials = credentials)

    data class Submitting(
        override val credentials: SignUpCredentials
    ) : SignUpUiState(credentials = credentials, buttonEnabled = false)

    data class SubmissionError(
        override val credentials: SignUpCredentials,
        val errorMessage: String
    ) : SignUpUiState(credentials = credentials)

    data class InputErrors(
        override val credentials: SignUpCredentials,
        val nameInputErrorMessage: String?,
        val emailInputErrorMessage: String?,
        val passwordInputErrorMessage: String?,
        val reTypePasswordInputErrorMessage: String?
    ) : SignUpUiState(credentials = credentials)
}
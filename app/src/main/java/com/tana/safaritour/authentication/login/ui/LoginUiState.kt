package com.tana.safaritour.authentication.login.ui

import com.tana.safaritour.authentication.login.data.LoginCredential

data class LoginUiState(
    val credentials: LoginCredential = LoginCredential(),
    val submitting: Boolean = false,
    val errorMessage: String? = null,
    val emailInputErrorMessage: String? = null,
    val passwordInputErrorMessage: String? = null
)
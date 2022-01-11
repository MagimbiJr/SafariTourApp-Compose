package com.tana.safaritour.authentication.signup.ui

import com.tana.safaritour.authentication.signup.data.SignUpCredentials

data class SignUpUiState(
    val credentials: SignUpCredentials = SignUpCredentials(),
    val submitting: Boolean = false,
    val active: Boolean = false,
    val errorMessage: String? = null,
    val nameInputErrorMessage: String? = null,
    val emailInputErrorMessage: String? = null,
    val passwordInputErrorMessage: String? = null,
    val reTypePasswordInputErrorMessage: String? = null
)

//sealed class SignUpUiState(
//    open val credentials: SignUpCredentials,
//    open val buttonEnabled: Boolean = true
//) {
//    object Initial : SignUpUiState(credentials = SignUpCredentials())
//
//    data class Active(
//        override val credentials: SignUpCredentials,
//        val nameInputErrorMessage: String? = null,
//        val emailInputErrorMessage: String? = null,
//        val passwordInputErrorMessage: String? = null,
//        val reTypePasswordInputErrorMessage: String? = null
//    ) : SignUpUiState(credentials = credentials)
//
//    data class Submitting(
//        override val credentials: SignUpCredentials,
//    ) : SignUpUiState(credentials = credentials, buttonEnabled = false)
//
//    data class SubmissionError(
//        override val credentials: SignUpCredentials,
//        val errorMessage: String
//    ) : SignUpUiState(credentials = credentials)
//
//    object Completed : SignUpUiState(
//        credentials = SignUpCredentials(),
//        buttonEnabled = false
//    )
//
////    data class InputErrors(
////        override val credentials: SignUpCredentials,
////        val nameInputErrorMessage: String? = null,
////        val emailInputErrorMessage: String? = null,
////        val passwordInputErrorMessage: String? = null,
////        val reTypePasswordInputErrorMessage: String? = null
////    ) : SignUpUiState(credentials = credentials)
//}


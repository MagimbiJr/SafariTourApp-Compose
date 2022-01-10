package com.tana.safaritour.utils

sealed class AuthResult {
    object Success : AuthResult()

    sealed class Failure : AuthResult() {
        object InvalidCredentials : Failure()

        object UnknownFailure : Failure()

        data class EmptyCredential(
            val emptyName: Boolean = false,
            val emptyEmail: Boolean = false,
            val emptyPassword: Boolean = false,
            val emptyVerifyPassword: Boolean = false
        ) : Failure()
    }
}
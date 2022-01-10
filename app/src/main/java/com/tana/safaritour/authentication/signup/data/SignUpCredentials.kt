package com.tana.safaritour.authentication.signup.data

data class SignUpCredentials(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val reTypePassword: String = ""
)

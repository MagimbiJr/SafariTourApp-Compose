package com.tana.safaritour.authentication.signup.data

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.tana.safaritour.utils.AuthResult

interface RegistrationRepository1 {

    fun createUser(credentials: SignUpCredentials)
}
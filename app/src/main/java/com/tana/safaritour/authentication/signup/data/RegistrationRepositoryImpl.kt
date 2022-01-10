package com.tana.safaritour.authentication.signup.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.tana.safaritour.utils.AuthResult
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    val auth: FirebaseAuth,
    var errorMessage: MutableLiveData<String?>,
    val currentUser: MutableLiveData<FirebaseUser?>
) {


    fun createUser(credentials: SignUpCredentials) {
        auth.createUserWithEmailAndPassword(
            credentials.email,
            credentials.password
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                currentUser.value = user
            }
        }.addOnFailureListener { exception ->
            errorMessage.value = exception.localizedMessage
        }
    }
}
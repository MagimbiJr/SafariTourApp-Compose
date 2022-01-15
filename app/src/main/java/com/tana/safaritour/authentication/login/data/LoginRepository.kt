package com.tana.safaritour.authentication.login.data

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val auth: FirebaseAuth,
    val errorMessage: MutableLiveData<String>,
    val currentUser: MutableLiveData<FirebaseUser>,
) {
    fun login(email: String?, password: String?) {
        auth.signInWithEmailAndPassword(
            email!!, password!!
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                currentUser.value = user
            } else {
                errorMessage.value = "An unknown error occurred"
            }
        }.addOnFailureListener { exception ->
            errorMessage.value = exception.localizedMessage
        }
    }
}
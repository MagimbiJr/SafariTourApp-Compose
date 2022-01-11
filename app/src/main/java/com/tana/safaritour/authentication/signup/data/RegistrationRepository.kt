package com.tana.safaritour.authentication.signup.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.tana.safaritour.utils.AuthResult
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    val auth: FirebaseAuth,
    val database: FirebaseFirestore,
    val errorMessage: MutableLiveData<String?>,
    val currentUser: MutableLiveData<FirebaseUser?>
) {


    fun createUser(credentials: SignUpCredentials) {
        auth.createUserWithEmailAndPassword(
            credentials.email.trim(),
            credentials.password.trim()
        ).addOnCompleteListener { task ->
            val registeredUser = hashMapOf(
                "name" to credentials.name.trim(),
                "email" to credentials.email.trim(),
                "profileDp" to credentials.profileDp.trim()
            )

            if (task.isSuccessful) {
                val user = auth.currentUser
                val userUid = user?.uid

                if (userUid != null) {
                    database.collection("users").document(userUid).set(registeredUser)
                }
                currentUser.value = user
            } else {
                errorMessage.value = "An unknown error occurred"
            }
        }.addOnFailureListener { exception ->
            errorMessage.value = exception.localizedMessage
        }
    }
}
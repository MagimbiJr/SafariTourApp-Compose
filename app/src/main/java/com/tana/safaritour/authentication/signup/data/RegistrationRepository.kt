package com.tana.safaritour.authentication.signup.data

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.tana.safaritour.authentication.signup.ui.SignUpUiState
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    val auth: FirebaseAuth,
    val database: FirebaseFirestore,
    val errorMessage: MutableLiveData<String?>,
    val currentUser: MutableLiveData<FirebaseUser?>
) {


    fun createUser(name: String, email: String?, password: String?, profileDp: String) {
        auth.createUserWithEmailAndPassword(email!!, password!!).addOnCompleteListener { task ->
            val registeredUser = hashMapOf(
                "name" to name,
                "email" to email,
                "profileDp" to profileDp
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
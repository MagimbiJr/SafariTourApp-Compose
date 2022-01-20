package com.tana.safaritour.utils

import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot

sealed class FirestoreResponse {
    object Initial : FirestoreResponse()
    data class OnSuccess(val querySnapshot: QuerySnapshot?) : FirestoreResponse()
    data class OnError(val exception: FirebaseFirestoreException) : FirestoreResponse()
}
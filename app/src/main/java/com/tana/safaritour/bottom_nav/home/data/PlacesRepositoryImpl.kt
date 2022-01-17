package com.tana.safaritour.bottom_nav.home.data

import com.google.firebase.firestore.FirebaseFirestore
import com.tana.safaritour.utils.FirestoreResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class PlacesRepositoryImpl(private val db: FirebaseFirestore) : PlacesRepository {

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun places(): Flow<FirestoreResponse> = callbackFlow {
        val collection = db.collection("places")
        val snapshotListener = collection.addSnapshotListener { value, error ->
            val response = if (error == null) {
                FirestoreResponse.OnSuccess(querySnapshot = value)
            } else {
                FirestoreResponse.OnError(error)
            }
            offer(response)
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun popularPlaces(): Flow<FirestoreResponse> = callbackFlow {
        val collection = db.collection("places")
        val snapshotListener = collection.addSnapshotListener { value, error ->
            val response = if (error == null) {
                FirestoreResponse.OnSuccess(querySnapshot = value)
            } else {
                FirestoreResponse.OnError(exception = error)
            }
            offer(response)
        }
        awaitClose {
            snapshotListener.remove()
        }
    }
}
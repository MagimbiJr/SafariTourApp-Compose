package com.tana.safaritour.bottom_nav.home.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.core.UserData
import com.tana.safaritour.utils.FirestoreResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class PlacesRepositoryImpl(
    private val db: FirebaseFirestore,
    override val places: MutableLiveData<List<Place>>,
    override val loading: MutableLiveData<Boolean>,
    override val popularPlaces: MutableLiveData<List<Place>>,
    //override val errorMessage: MutableLiveData<String>
) : PlacesRepository {

    override suspend fun places() {
        loading.value = true
        db.collection("places")
            .get().addOnSuccessListener { result ->
                val placesResult = result.toObjects(Place::class.java)

                places.value = placesResult
            }.addOnFailureListener { exception ->
                Log.d("TAG", "places: ${exception.localizedMessage}")
            }
        loading.value = false
    }

    override suspend fun popularPlaces() {
        val source = Source.CACHE
        db.collection("places")
            .get(source).addOnSuccessListener { result ->
                popularPlaces.value = result.toObjects(Place::class.java)
            }.addOnFailureListener { exception ->
                Log.d("TAG", "popularPlaces: ${exception.localizedMessage}")
            }
    }
}
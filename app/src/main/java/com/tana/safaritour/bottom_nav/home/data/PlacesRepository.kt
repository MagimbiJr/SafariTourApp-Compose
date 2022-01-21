package com.tana.safaritour.bottom_nav.home.data

import androidx.lifecycle.MutableLiveData
import com.tana.safaritour.utils.FirestoreResponse
import kotlinx.coroutines.flow.Flow

interface PlacesRepository {
    val places: MutableLiveData<List<Place>>
    val popularPlaces: MutableLiveData<List<Place>>
    var loading: Boolean
    //val errorMessage: MutableLiveData<String>

    suspend fun places()

    suspend fun popularPlaces()
}
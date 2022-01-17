package com.tana.safaritour.bottom_nav.home.data

import com.tana.safaritour.utils.FirestoreResponse
import kotlinx.coroutines.flow.Flow

interface PlacesRepository {
    suspend fun places(): Flow<FirestoreResponse>

    suspend fun popularPlaces(): Flow<FirestoreResponse>
}
package com.tana.safaritour.bottom_nav.home.ui

import android.util.Log
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tana.safaritour.bottom_nav.home.data.Place
import com.tana.safaritour.bottom_nav.home.data.PlacesRepository
import com.tana.safaritour.bottom_nav.home.data.PlacesRepositoryImpl
import com.tana.safaritour.utils.FirestoreResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: PlacesRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState = _uiState.asStateFlow()

    val placesStateFlow = MutableStateFlow<FirestoreResponse?>(null)

    init {
        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(
                isLoading = repository.loading
            )

            Log.d("TAG", "places: ${repository.places()}")
            _uiState.value = _uiState.value.copy(
                //isLoading = repository.loading,
                places = repository.places,
                //popularPlaces = repository.popularPlaces
            )
        }
    }

}
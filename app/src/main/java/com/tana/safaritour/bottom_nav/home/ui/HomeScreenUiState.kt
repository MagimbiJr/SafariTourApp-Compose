package com.tana.safaritour.bottom_nav.home.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tana.safaritour.bottom_nav.home.data.Place
import com.tana.safaritour.utils.FirestoreResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class HomeScreenUiState(
    val isLoading: Boolean = false,
    val places: LiveData<List<Place>>? = null,
    val errorMessage: String = ""
)
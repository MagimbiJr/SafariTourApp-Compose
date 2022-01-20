package com.tana.safaritour.bottom_nav.home.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.SystemUiController

@Composable
fun HomeScreen(
    systemUiController: SystemUiController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()
    systemUiController.setSystemBarsColor(MaterialTheme.colors.background)
    HomeContent(homeScreenUiState = uiState.value)
}
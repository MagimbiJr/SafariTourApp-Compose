package com.tana.safaritour.utils

sealed class AppUiEvents {
    object PopBackStack : AppUiEvents()
    data class Navigate(val route: String) : AppUiEvents()
    data class ShowSnackBar(
        val message: String,
        val action: String? = null
    ) : AppUiEvents()
}

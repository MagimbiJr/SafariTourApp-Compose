package com.tana.safaritour.bottom_nav.home.data

data class Place(
    val id: String,
    val name: String,
    val location: String,
    val type: String,
    val isFavorite: Boolean,
    val rates: Int,
    val description: String,
    val image: String
) {
    constructor() : this("","", "", "", false, 0,"", "")
}
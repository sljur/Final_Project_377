package com.jurado.finalproject.data

// Classes for the response from the geocoding API
data class CityData(
    val id: Int,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val country: String,
    val admin1: String? = null
)

data class GeocodingResponse(
    val results: List<CityData>
)
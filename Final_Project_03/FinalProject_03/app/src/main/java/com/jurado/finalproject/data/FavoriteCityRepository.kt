package com.jurado.finalproject.data
import androidx.lifecycle.LiveData

class FavoriteCityRepository(private val favoriteCityDao: FavoriteCityDao) {

    // Get all favorite cities
    val allFavorites: LiveData<List<FavoriteCity>> = favoriteCityDao.getAllFavorites()

    // Add a city to favorites
    suspend fun addCity(city: FavoriteCity) {
        favoriteCityDao.insert(city)
    }

    // Delete a city from favorites
    suspend fun deleteCity(city: FavoriteCity) {
        favoriteCityDao.delete(city)
    }
}


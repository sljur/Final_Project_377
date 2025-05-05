package com.jurado.finalproject.ui

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import com.jurado.finalproject.data.FavoriteCityRepository
import com.jurado.finalproject.data.FavoriteCity
import com.jurado.finalproject.data.WeatherDatabase


class FavoriteCityViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FavoriteCityRepository
    val allFavorites: LiveData<List<FavoriteCity>>

    init {
        val dao = WeatherDatabase.getDatabase(application).favoriteCityDao()
        repository = FavoriteCityRepository(dao)
        allFavorites = repository.allFavorites
    }

    fun addCity(city: FavoriteCity) = viewModelScope.launch {
        repository.addCity(city)
    }

    fun deleteCity(city: FavoriteCity) = viewModelScope.launch {
        repository.deleteCity(city)
    }
}

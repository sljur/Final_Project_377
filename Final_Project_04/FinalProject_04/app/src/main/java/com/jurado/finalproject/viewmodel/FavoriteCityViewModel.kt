package com.jurado.finalproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.jurado.finalproject.data.FavoriteCity
import com.jurado.finalproject.data.FavoriteCityRepository
import kotlinx.coroutines.launch

class FavoriteCityViewModel(private val repository: FavoriteCityRepository) :
    ViewModel() {

    val allFavorites: LiveData<List<FavoriteCity>> = repository.allFavorites

    fun insert(city: FavoriteCity) = viewModelScope.launch {
        repository.addCity(city)
    }

    fun delete(city: FavoriteCity) = viewModelScope.launch {
        repository.deleteCity(city)
    }
}

// Factory to create the ViewModel with the repository
class FavoriteCityViewModelFactory(private val repository: FavoriteCityRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteCityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoriteCityViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
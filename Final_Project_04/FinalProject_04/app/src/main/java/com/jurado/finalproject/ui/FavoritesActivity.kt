package com.jurado.finalproject.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jurado.finalproject.R
import com.jurado.finalproject.WeatherActivity
import com.jurado.finalproject.data.FavoriteCity
import com.jurado.finalproject.data.FavoriteCityDatabase
import com.jurado.finalproject.data.FavoriteCityRepository
import com.jurado.finalproject.viewmodel.FavoriteCityViewModel
import com.jurado.finalproject.viewmodel.FavoriteCityViewModelFactory

// Activity to display the list of favorite cities
class FavoritesActivity : AppCompatActivity() {
    private lateinit var favoriteCityViewModel: FavoriteCityViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var favoriteCityAdapter: FavoriteCityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        // Initialize the RecyclerView and its layout manager
        recyclerView = findViewById(R.id.recyclerViewFavorites)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the ViewModel and get the DAO instance from the database
        val dao = FavoriteCityDatabase.getDatabase(applicationContext).favoriteCityDao()

        // Create a repository instance and create ViewModel instance using the factory
        val repository = FavoriteCityRepository(dao)
        val factory = FavoriteCityViewModelFactory(repository)
        favoriteCityViewModel = ViewModelProvider(this, factory).get(FavoriteCityViewModel::class.java)

        // Initialize the adapter
        favoriteCityAdapter = FavoriteCityAdapter(
            onRemoveClick = { favoriteCity ->
                favoriteCityViewModel.delete(favoriteCity)
            },
            onItemClick = { favoriteCity ->
                navigateToWeatherActivity(favoriteCity)
            }
        )
        recyclerView.adapter = favoriteCityAdapter

        // Use LiveData to observe the list of favorite cities
        favoriteCityViewModel.allFavorites.observe(this) { favoriteCities ->
            favoriteCities?.let {
                favoriteCityAdapter.submitList(it)
            }
        }
    }

    private fun navigateToWeatherActivity(favoriteCity: FavoriteCity) {
        val intent = Intent(this, WeatherActivity::class.java).apply {
            putExtra("city_name", favoriteCity.cityName)
            putExtra("latitude", favoriteCity.latitude)
            putExtra("longitude", favoriteCity.longitude)
        }
        startActivity(intent)
    }
}
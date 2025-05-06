package com.jurado.finalproject.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jurado.finalproject.R
import com.jurado.finalproject.data.FavoriteCity
import com.jurado.finalproject.WeatherActivity


class FavoritesActivity : AppCompatActivity() {

    private lateinit var favoriteCityAdapter: FavoriteCityAdapter
    private lateinit var recyclerView: RecyclerView
    private val favoriteCityViewModel: FavoriteCityViewModel by viewModels() // Use ViewModel to get data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        recyclerView = findViewById(R.id.recyclerViewFavorites)
        recyclerView.layoutManager = LinearLayoutManager(this)
        favoriteCityAdapter = FavoriteCityAdapter(emptyList()) { city -> onCityClick(city) }
        recyclerView.adapter = favoriteCityAdapter

        favoriteCityViewModel.allFavorites.observe(this) { favoriteCities ->
            Toast.makeText(this, "Loaded ${favoriteCities.size} favorites", Toast.LENGTH_SHORT).show()
            favoriteCityAdapter.updateData(favoriteCities)
        }
    }

    // This method will be triggered when a city is clicked
    private fun onCityClick(city: FavoriteCity) {
        // Intent to pass city data to WeatherActivity
        val intent = Intent(this, WeatherActivity::class.java).apply {
            putExtra("city_name", city.cityName)  // Pass city name
            putExtra("latitude", city.latitude)  // Pass latitude
            putExtra("longitude", city.longitude)  // Pass longitude
        }
        startActivity(intent)  // Start WeatherActivity
    }
}

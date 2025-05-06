package com.jurado.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jurado.finalproject.data.CityData
import com.jurado.finalproject.network.RetrofitClient
import com.jurado.finalproject.ui.CityAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.jurado.finalproject.ui.FavoritesActivity
import com.jurado.finalproject.data.FavoriteCityDatabase
import com.jurado.finalproject.data.FavoriteCity



class MainActivity : AppCompatActivity() {
    private lateinit var cityAdapter: CityAdapter
    private lateinit var cityRecyclerView: RecyclerView
    private lateinit var cityInput: EditText
    private lateinit var submitButton: Button
    private lateinit var submitFaveButton: Button
    private var selectedCity: CityData? = null // <-- Declare a variable to hold the selected city

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Insets padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize UI components
        cityRecyclerView = findViewById(R.id.cityRecyclerView)
        cityInput = findViewById(R.id.cityInput)
        submitButton = findViewById(R.id.submitButton)
        submitFaveButton = findViewById(R.id.submitFaveButton)

        cityRecyclerView.layoutManager = LinearLayoutManager(this)
        cityAdapter = CityAdapter(
            emptyList(),
            onItemClick = { city -> navigateToWeatherActivity(city) },
            onFavoriteClick = { city -> saveCityToFavorites(city) }
        )
        cityRecyclerView.adapter = cityAdapter

        submitButton.setOnClickListener {
            val cityName = cityInput.text.toString().trim()
            if (cityName.isNotEmpty()) {
                searchCities(cityName)
            } else {
                Toast.makeText(this, "Please enter a city name", Toast.LENGTH_SHORT).show()
            }
        }

        // Set up the click listener for the submitFaveButton
        submitFaveButton.setOnClickListener {
            val city = selectedCity // Get the currently selected city
            if (city != null) {
                saveCityToFavorites(city)
            } else {
                Toast.makeText(this, "No city selected to favorite.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Searches for cities using the provided city name
    private fun searchCities(cityName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.geocodingService.searchCities(cityName)
                if (response.isSuccessful) {
                    val cityList = response.body()?.results ?: emptyList()

                    withContext(Dispatchers.Main) {
                        if (cityList.isEmpty()) {
                            Toast.makeText(this@MainActivity, "No cities found", Toast.LENGTH_SHORT).show()
                            cityAdapter.updateData(cityList)
                        } else if (cityList.size == 1) {
                            navigateToWeatherActivity(cityList[0])
                        } else {
                            cityAdapter.updateData(cityList)
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@MainActivity, "Error searching for cities", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Error searching for cities", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // Navigates to the WeatherActivity with the selected city's data
    private fun navigateToWeatherActivity(city: CityData) {
        selectedCity = city // Store the selected city
        val intent = Intent(this, WeatherActivity::class.java).apply {
            putExtra("city_name", city.name)
            putExtra("latitude", city.latitude)
            putExtra("longitude", city.longitude)
        }
        startActivity(intent)
    }

    // Save the city to favorites
    private fun saveCityToFavorites(city: CityData) {
        CoroutineScope(Dispatchers.IO).launch {
            val favorite = FavoriteCity(
                cityName = city.name,
                latitude = city.latitude,
                longitude = city.longitude
            )

            val db = FavoriteCityDatabase.getDatabase(applicationContext)
            db.favoriteCityDao().insert(favorite)
            withContext(Dispatchers.Main) {
                Toast.makeText(this@MainActivity, "${city.name} added to favorites", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

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

class MainActivity : AppCompatActivity() {
    // Variables for UI components
    private lateinit var cityAdapter: CityAdapter
    private lateinit var cityRecyclerView: RecyclerView
    private lateinit var cityInput: EditText
    private lateinit var submitButton: Button

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

        cityRecyclerView.layoutManager = LinearLayoutManager(this)
        cityAdapter = CityAdapter(emptyList()) { city ->
            navigateToWeatherActivity(city)
        }
        cityRecyclerView.adapter = cityAdapter

        submitButton.setOnClickListener {
            val cityName = cityInput.text.toString().trim()
            if (cityName.isNotEmpty()) {
                searchCities(cityName)
            } else {
                Toast.makeText(this, "Please enter a city name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Searches for cities using the provided city name
    private fun searchCities(cityName: String) {
        // Launch Coroutine on the IO dispatcher
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Make the API call to search for cities
                val response = RetrofitClient.geocodingService.searchCities(cityName)
                if (response.isSuccessful) {
                    val cityList = response.body()?.results ?: emptyList()

                    // Switch to Main dispatcher to update the UI
                    withContext(Dispatchers.Main) {
                        if (cityList.isEmpty()) {
                            Toast.makeText(this@MainActivity, "No cities found", Toast.LENGTH_SHORT).show()
                            cityAdapter.updateData(cityList)
                        } else if (cityList.size == 1) {
                            // If only one city is found, navigate directly
                            navigateToWeatherActivity(cityList[0])
                        } else {
                            // If multiple cities are found, update the list
                            cityAdapter.updateData(cityList)
                        }
                    }
                } else {
                    // Handle error
                    println("Error: ${response.errorBody()?.string()}")
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@MainActivity, "Error searching for cities", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                // Handle exception
                println("Exception: ${e.message}")
                withContext(Dispatchers.Main){
                    Toast.makeText(this@MainActivity, "Error searching for cities", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // Navigates to the WeatherActivity with the selected city's data
    private fun navigateToWeatherActivity(city: CityData) {
        val intent = Intent(this, WeatherActivity::class.java).apply {
            putExtra("city_name", city.name)
            putExtra("latitude", city.latitude)
            putExtra("longitude", city.longitude)
        }
        startActivity(intent)
    }
}
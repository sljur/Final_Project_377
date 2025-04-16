package com.jurado.finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import com.jurado.finalproject.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// Adapter for displaying a list of weather data in a RecyclerView
class WeatherAdapter(private val weatherList: List<WeatherData>) :
    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    // ViewHolder for a single weather item
    class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dateText: TextView = view.findViewById(R.id.dateText)
        val weatherDescription: TextView = view.findViewById(R.id.weatherDescription)
        val weatherIcon: ImageView = view.findViewById(R.id.weatherIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weather, parent, false)
        return WeatherViewHolder(view)
    }

    // Display the data at the specified position
    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weather = weatherList[position]

        // Show "Day0", "Day1", etc. instead of the date
        holder.dateText.text = "Day$position" // This will display 'Day0', 'Day1', etc.

        holder.weatherDescription.text = "${weather.condition}, ${weather.temperature}°F"

        // Change the icon dynamically based on weather condition
        val iconRes = when (weather.condition.lowercase()) {
            "sunny" -> R.drawable.ic_sun
            "cloudy" -> R.drawable.ic_cloud
            "rainy" -> R.drawable.ic_rain
            else -> R.drawable.ic_unknown
        }

        // Set the weather icon
        holder.weatherIcon.setImageResource(iconRes)
    }

    override fun getItemCount(): Int = weatherList.size
}

// Activity for displaying the weather forecast
class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val cityName = intent.getStringExtra("city_name") ?: "Unknown"
        val latitude = intent.getDoubleExtra("latitude", 0.0)
        val longitude = intent.getDoubleExtra("longitude", 0.0)

        // Initialize UI components
        val weatherImage = findViewById<ImageView>(R.id.weatherImage)
        val recyclerView = findViewById<RecyclerView>(R.id.weatherRecyclerView)
        val backButton = findViewById<Button>(R.id.backButton)

        recyclerView.layoutManager = LinearLayoutManager(this)

        backButton.setOnClickListener {
            // Finish the activity when the back button is pressed
            finish()
        }

        fetchWeatherForecast(latitude, longitude, recyclerView, weatherImage)
    }

    // Fetches the weather forecast for the given latitude and longitude
    private fun fetchWeatherForecast(latitude: Double, longitude: Double, recyclerView: RecyclerView, weatherImage: ImageView) {
        // Launch Coroutine on the IO dispatcher
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Make the API call to get the forecast
                val response = RetrofitClient.forecastService.getForecast(latitude, longitude)
                if (response.isSuccessful) {
                    val forecastResponse = response.body()
                    if (forecastResponse != null) {
                        val weatherList = forecastResponse.daily.time.mapIndexed { index, time ->
                            val condition = getWeatherCondition(forecastResponse.daily.weathercode[index])
                            WeatherData(
                                date = time,
                                condition = condition,
                                temperature = forecastResponse.daily.temperature_2m_max[index].toInt()
                            )
                        }

                        // Switch to Main dispatcher to update the UI
                        withContext(Dispatchers.Main) {
                            val firstWeatherCondition = weatherList.firstOrNull()?.condition ?: "unknown"
                            val iconRes = when (firstWeatherCondition.lowercase()) {
                                "sunny" -> R.drawable.ic_sun
                                "cloudy" -> R.drawable.ic_cloud
                                "rainy" -> R.drawable.ic_rain
                                else -> R.drawable.ic_unknown
                            }
                            weatherImage.setImageResource(iconRes)
                            recyclerView.adapter = WeatherAdapter(weatherList)
                        }
                    }
                } else {
                    // Handle error
                    println("Error: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                // Handle exception
                println("Exception: ${e.message}")
            }
        }
    }

    // Gets the weather condition string based on the weather code
    private fun getWeatherCondition(weatherCode: Int): String {
        return when (weatherCode) {
            0 -> "Sunny"
            1, 2, 3 -> "Cloudy"
            45, 48 -> "Foggy"
            51, 53, 55 -> "Drizzle"
            56, 57 -> "Freezing Drizzle"
            61, 63, 65 -> "Rainy"
            66, 67 -> "Freezing Rain"
            71, 73, 75 -> "Snowy"
            77 -> "Snow Grains"
            80, 81, 82 -> "Rain Showers"
            85, 86 -> "Snow Showers"
            95 -> "Thunderstorm"
            96, 99 -> "Thunderstorm with Hail"
            else -> "Unknown"
        }
    }
}

data class WeatherData(val date: String, val condition: String, val temperature: Int)


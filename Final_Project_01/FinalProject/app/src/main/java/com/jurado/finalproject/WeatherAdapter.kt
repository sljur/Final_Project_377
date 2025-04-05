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


class WeatherAdapter(private val weatherList: List<WeatherData>) :
    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

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
            else -> R.drawable.ic_unknown // Fallback icon
        }

        holder.weatherIcon.setImageResource(iconRes)
    }

    override fun getItemCount(): Int = weatherList.size
}

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val weatherList = listOf(
            WeatherData("Monday, April 5", "Sunny", 75),
            WeatherData("Tuesday, April 6", "Cloudy", 68),
            WeatherData("Wednesday, April 7", "Rainy", 60)
        )

        // Set the top weather image dynamically
        val weatherImage = findViewById<ImageView>(R.id.weatherImage)
        val firstWeatherCondition = weatherList.firstOrNull()?.condition ?: "unknown"
        val iconRes = when (firstWeatherCondition.lowercase()) {
            "sunny" -> R.drawable.ic_sun
            "cloudy" -> R.drawable.ic_cloud
            "rainy" -> R.drawable.ic_rain
            else -> R.drawable.ic_unknown
        }
        weatherImage.setImageResource(iconRes)

        // Set up RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.weatherRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WeatherAdapter(weatherList)

    }
}

data class WeatherData(val date: String, val condition: String, val temperature: Int)


package com.jurado.finalproject.data

// Classes for the response from the Open-Meteo API
data class ForecastResponse(
    val daily: DailyForecast
)

data class DailyForecast(
    val time: List<String>,
    val weathercode: List<Int>,
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>
)
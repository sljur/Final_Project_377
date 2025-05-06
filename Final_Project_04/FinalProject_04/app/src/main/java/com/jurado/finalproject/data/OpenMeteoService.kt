package com.jurado.finalproject.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMeteoService {
    @GET("search")
    suspend fun searchCities(
        @Query("name") cityName: String,
        @Query("count") count: Int = 10,
        @Query("language") language: String = "en",
        @Query("format") format: String = "json"
    ): Response<GeocodingResponse>

    @GET("forecast")
    suspend fun getForecast(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("daily") daily: String = "weathercode,temperature_2m_max,temperature_2m_min",
        @Query("timezone") timezone: String = "auto",
        @Query("forecast_days") forecastDays: Int = 7,
        @Query("format") format: String = "json",
        @Query("temperature_unit") unit: String = "fahrenheit",
    ): Response<ForecastResponse>
}
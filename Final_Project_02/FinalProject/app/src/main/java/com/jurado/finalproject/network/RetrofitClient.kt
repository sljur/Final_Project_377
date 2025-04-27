package com.jurado.finalproject.network

import com.jurado.finalproject.data.OpenMeteoService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // URL for Open-Meteo Geocoding API
    private const val BASE_URL_GEOCODING = "https://geocoding-api.open-meteo.com/v1/"

    // URL for Open-Meteo Forecast API
    private const val BASE_URL_FORECAST = "https://api.open-meteo.com/v1/"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    // Instance of the OpenMeteoService for geocoding
    val geocodingService: OpenMeteoService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_GEOCODING)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenMeteoService::class.java)
    }

    // Instance of the OpenMeteoService for weather forecasting
    val forecastService: OpenMeteoService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_FORECAST)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenMeteoService::class.java)
    }
}
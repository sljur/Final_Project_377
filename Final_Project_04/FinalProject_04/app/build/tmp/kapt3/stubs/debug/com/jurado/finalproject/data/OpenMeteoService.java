package com.jurado.finalproject.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JZ\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\t2\b\b\u0003\u0010\u000e\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ<\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0012\u001a\u00020\t2\b\b\u0003\u0010\u0013\u001a\u00020\f2\b\b\u0003\u0010\u0014\u001a\u00020\t2\b\b\u0003\u0010\r\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/jurado/finalproject/data/OpenMeteoService;", "", "getForecast", "Lretrofit2/Response;", "Lcom/jurado/finalproject/data/ForecastResponse;", "latitude", "", "longitude", "daily", "", "timezone", "forecastDays", "", "format", "unit", "(DDLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchCities", "Lcom/jurado/finalproject/data/GeocodingResponse;", "cityName", "count", "language", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface OpenMeteoService {
    
    @retrofit2.http.GET(value = "search")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchCities(@retrofit2.http.Query(value = "name")
    @org.jetbrains.annotations.NotNull()
    java.lang.String cityName, @retrofit2.http.Query(value = "count")
    int count, @retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Query(value = "format")
    @org.jetbrains.annotations.NotNull()
    java.lang.String format, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.jurado.finalproject.data.GeocodingResponse>> $completion);
    
    @retrofit2.http.GET(value = "forecast")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getForecast(@retrofit2.http.Query(value = "latitude")
    double latitude, @retrofit2.http.Query(value = "longitude")
    double longitude, @retrofit2.http.Query(value = "daily")
    @org.jetbrains.annotations.NotNull()
    java.lang.String daily, @retrofit2.http.Query(value = "timezone")
    @org.jetbrains.annotations.NotNull()
    java.lang.String timezone, @retrofit2.http.Query(value = "forecast_days")
    int forecastDays, @retrofit2.http.Query(value = "format")
    @org.jetbrains.annotations.NotNull()
    java.lang.String format, @retrofit2.http.Query(value = "temperature_unit")
    @org.jetbrains.annotations.NotNull()
    java.lang.String unit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.jurado.finalproject.data.ForecastResponse>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}
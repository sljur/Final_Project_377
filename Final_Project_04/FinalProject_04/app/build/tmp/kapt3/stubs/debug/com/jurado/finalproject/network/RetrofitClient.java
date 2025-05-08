package com.jurado.finalproject.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/jurado/finalproject/network/RetrofitClient;", "", "()V", "BASE_URL_FORECAST", "", "BASE_URL_GEOCODING", "forecastService", "Lcom/jurado/finalproject/data/OpenMeteoService;", "getForecastService", "()Lcom/jurado/finalproject/data/OpenMeteoService;", "forecastService$delegate", "Lkotlin/Lazy;", "geocodingService", "getGeocodingService", "geocodingService$delegate", "loggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "app_debug"})
public final class RetrofitClient {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL_GEOCODING = "https://geocoding-api.open-meteo.com/v1/";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL_FORECAST = "https://api.open-meteo.com/v1/";
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.logging.HttpLoggingInterceptor loggingInterceptor = null;
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.OkHttpClient okHttpClient = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy geocodingService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy forecastService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.jurado.finalproject.network.RetrofitClient INSTANCE = null;
    
    private RetrofitClient() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jurado.finalproject.data.OpenMeteoService getGeocodingService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jurado.finalproject.data.OpenMeteoService getForecastService() {
        return null;
    }
}
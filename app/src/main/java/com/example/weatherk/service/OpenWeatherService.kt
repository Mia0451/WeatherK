package com.example.weatherk.service

import com.example.weatherk.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherService {

    @GET("data/2.5/weather")
    suspend fun getWeather(@Query("lat") lat: Double, @Query("lon") lon: Double): WeatherResponse
}
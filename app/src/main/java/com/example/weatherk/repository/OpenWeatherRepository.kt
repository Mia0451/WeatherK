package com.example.weatherk.repository

import com.example.weatherk.model.WeatherResponse

interface OpenWeatherRepository {

    suspend fun getWeather(lat: Double, lon: Double): WeatherResponse
}
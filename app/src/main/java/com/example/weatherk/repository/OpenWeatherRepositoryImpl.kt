package com.example.weatherk.repository

import com.example.weatherk.model.WeatherResponse
import com.example.weatherk.service.OpenWeatherService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OpenWeatherRepositoryImpl @Inject constructor(
    private val openWeatherService: OpenWeatherService
): OpenWeatherRepository {

    override suspend fun getWeather(lat: Double, lon: Double): WeatherResponse {
        return withContext(Dispatchers.IO) {
            openWeatherService.getWeather(lat, lon)
        }
    }
}
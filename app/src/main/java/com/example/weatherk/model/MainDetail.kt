package com.example.weatherk.model

data class MainDetail(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Double,
    val humidity: Double,
    val sea_level: Double,
    val grnd_level: Double
)

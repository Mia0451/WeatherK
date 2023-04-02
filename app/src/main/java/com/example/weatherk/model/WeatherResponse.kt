package com.example.weatherk.model

data class WeatherResponse(
    val coord: Coordinate,
    val weather: List<Weather>,
    val base: String,
    val main: MainDetail,
    val visibility: Long,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Long,
    val sys: SystemInfo,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int
)

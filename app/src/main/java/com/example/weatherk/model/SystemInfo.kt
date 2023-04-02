package com.example.weatherk.model

data class SystemInfo(
    val type: Int,
    val id: Long,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)

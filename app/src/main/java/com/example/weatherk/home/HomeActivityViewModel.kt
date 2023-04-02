package com.example.weatherk.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherk.model.WeatherResponse
import com.example.weatherk.repository.OpenWeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeActivityViewModel @Inject constructor(
    private val openWeatherRepository: OpenWeatherRepository
): ViewModel() {

    private val weatherResponseFlow = MutableSharedFlow<WeatherResponse>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)


    init {
        viewModelScope.launch {
            val weatherResponse = openWeatherRepository.getWeather(44.34, 10.99)
            weatherResponseFlow.tryEmit(weatherResponse)
        }
    }

    fun getWeatherResponseFlow(): Flow<WeatherResponse> {
        return weatherResponseFlow
    }
}
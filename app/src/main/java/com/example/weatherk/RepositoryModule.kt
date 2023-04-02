package com.example.weatherk

import com.example.weatherk.repository.OpenWeatherRepository
import com.example.weatherk.repository.OpenWeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    fun provideOpenWeatherRepository(impl: OpenWeatherRepositoryImpl): OpenWeatherRepository {
        return impl
    }
}
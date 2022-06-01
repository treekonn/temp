package com.example.mnqr54.domain

import com.example.mnqr54.data.WeatherRepositoryImpl
import com.example.mnqr54.data.api.WeatherModelApi

class GetWeatherDataUseCase() {
    private val repository = WeatherRepositoryImpl()

    suspend fun getWeatherData(): WeatherModelApi {
        return repository.getWeather()
    }
}
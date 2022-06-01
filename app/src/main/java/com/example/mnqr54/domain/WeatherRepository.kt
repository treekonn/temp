package com.example.mnqr54.domain

import com.example.mnqr54.data.api.WeatherModelApi

interface WeatherRepository {

    suspend fun getWeather(): WeatherModelApi
}
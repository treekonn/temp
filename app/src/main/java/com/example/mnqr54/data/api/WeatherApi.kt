package com.example.mnqr54.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface WeatherApi {

    @Headers(
        "X-RapidAPI-Host: community-open-weather-map.p.rapidapi.com",
        "X-RapidAPI-Key: 34b0a239f8msh5b0efda74c5bc03p10975djsn7307ccb112f8"
    )
    @GET("/weather?q=Minsk&lat=0&lon=0&id=2172797&lang=ru&units=metric&mode=JSON")
    fun getWeather(): Call<WeatherModelApi>

}
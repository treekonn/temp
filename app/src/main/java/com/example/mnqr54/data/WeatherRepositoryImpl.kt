package com.example.mnqr54.data

import android.nfc.FormatException
import com.example.mnqr54.data.api.WeatherApi
import com.example.mnqr54.data.api.WeatherModelApi
import com.example.mnqr54.domain.WeatherRepository
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

val okHttpClient: OkHttpClient = OkHttpClient()
    .newBuilder()
    .build()

val retrofit: Retrofit = Retrofit.Builder()
    .client(okHttpClient)
    .baseUrl("https://community-open-weather-map.p.rapidapi.com")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val weatherApi: WeatherApi = retrofit.create(WeatherApi::class.java)

class WeatherRepositoryImpl : WeatherRepository {

    override suspend fun getWeather(): WeatherModelApi {
        val response = weatherApi.getWeather().awaitResponse()
        val data = response.body()
        return data ?: throw FormatException()
    }
}
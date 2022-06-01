package com.example.mnqr54.data.api


import com.google.gson.annotations.SerializedName

data class WeatherModelApi(
    @SerializedName("name") val name: String,
    @SerializedName("wind") val wind: WindItem,
    @SerializedName("weather") val weather: List<WeatherItem>,
    @SerializedName("main") val main: MainItem
){
    data class WindItem(
        @SerializedName("speed") val speed: Float
    )

    data class WeatherItem(
        @SerializedName("description") val description: String
    )

    data class MainItem(
        @SerializedName("temp") val temp: Float,
        @SerializedName("feels_like") val feels_like: Float,
        @SerializedName("pressure") val pressure: Int,
        @SerializedName("humidity") val humidity: Int
    )
}

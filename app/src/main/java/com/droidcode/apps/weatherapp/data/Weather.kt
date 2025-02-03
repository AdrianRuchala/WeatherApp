package com.droidcode.apps.weatherapp.data

data class Weather (
    val temp_C: String?,
    val feelsLikeC: String?,
    val cloudCover: String?,
    val humidity: String?,
    val weatherDesc: List<WeatherDescription>?
)

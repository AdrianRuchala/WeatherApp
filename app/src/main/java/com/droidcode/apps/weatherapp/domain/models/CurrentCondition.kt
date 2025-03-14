package com.droidcode.apps.weatherapp.domain.models

data class CurrentCondition (
    val temp_C: String?,
    val feelsLikeC: String?,
    val cloudcover: String?,
    val humidity: String?,
    val windspeedKmph: String?,
    val weatherDesc: List<WeatherDescription>?
)

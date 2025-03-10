package com.droidcode.apps.weatherapp.domain.models

data class WeatherResponse(
    val current_condition: List<CurrentCondition>
)

package com.droidcode.apps.weatherapp.data.repository

import com.droidcode.apps.weatherapp.data.CurrentCondition

data class WeatherResponse(
    val current_condition: List<CurrentCondition>
)

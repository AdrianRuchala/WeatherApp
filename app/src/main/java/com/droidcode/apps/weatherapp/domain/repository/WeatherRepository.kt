package com.droidcode.apps.weatherapp.domain.repository

import com.droidcode.apps.weatherapp.domain.models.WeatherResponse

interface WeatherRepository {
    suspend fun getWeather(city: String): WeatherResponse
}

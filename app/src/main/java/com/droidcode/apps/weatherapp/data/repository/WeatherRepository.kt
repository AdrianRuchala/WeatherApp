package com.droidcode.apps.weatherapp.data.repository

import com.droidcode.apps.weatherapp.data.Weather
import com.droidcode.apps.weatherapp.data.remote.WetherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: WetherApi
) {
    suspend fun getWeather(city: String): Weather {
        return api.getWeather(city)
    }
}

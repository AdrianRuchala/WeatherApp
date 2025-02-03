package com.droidcode.apps.weatherapp.data.repository

import com.droidcode.apps.weatherapp.data.CityData
import com.droidcode.apps.weatherapp.data.Weather
import com.droidcode.apps.weatherapp.data.remote.WetherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: WetherApi
) {
    suspend fun getCityData(city: String): CityData? {
        return api.searchCity(city).firstOrNull()
    }

    suspend fun getWeather(woeid: Int): Weather {
        return api.getWeather(woeid).first()
    }
}

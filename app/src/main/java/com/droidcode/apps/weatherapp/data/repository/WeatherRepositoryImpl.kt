package com.droidcode.apps.weatherapp.data.repository

import com.droidcode.apps.weatherapp.data.remote.WeatherApi
import com.droidcode.apps.weatherapp.domain.models.WeatherResponse
import com.droidcode.apps.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeather(city: String): WeatherResponse {
        return api.getWeather(city)
    }
}

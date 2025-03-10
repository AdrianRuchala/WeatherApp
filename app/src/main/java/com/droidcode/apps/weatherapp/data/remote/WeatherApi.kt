package com.droidcode.apps.weatherapp.data.remote

import com.droidcode.apps.weatherapp.domain.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {
    @GET("/{city}?format=j1")
    suspend fun getWeather(@Path("city") city: String): WeatherResponse
}

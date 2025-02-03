package com.droidcode.apps.weatherapp.data.remote

import com.droidcode.apps.weatherapp.data.CityData
import com.droidcode.apps.weatherapp.data.Weather
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WetherApi {
    @GET("location/search/")
    suspend fun searchCity(@Query("query") city: String): List<CityData>

    @GET("location/{woeid}/")
    suspend fun getWeather(@Path("woeid") woeid: Int): List<Weather>
}

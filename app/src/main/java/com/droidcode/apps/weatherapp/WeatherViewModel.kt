package com.droidcode.apps.weatherapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.droidcode.apps.weatherapp.data.Weather
import com.droidcode.apps.weatherapp.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    val weatherState = MutableLiveData<Weather?>()

    suspend fun getCityData(name: String){
        repository.getCityData(name)
    }

    suspend fun getWeather(woeid: Int){
        weatherState.value = repository.getWeather(woeid)
    }
}
